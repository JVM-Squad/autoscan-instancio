package org.instancio;

import org.instancio.generator.Generator;
import org.instancio.model.InternalModel;
import org.instancio.model.ModelContext;
import org.instancio.util.ObjectUtils;

import java.util.Arrays;

import static org.instancio.util.ReflectionUtils.getField;

public class ClassCreationApi<T> implements CreationApi<T> {

    private final Class<?> rootClass;
    private final ModelContext.Builder modelContextBuilder;

    public ClassCreationApi(Class<T> klass) {
        this.rootClass = klass;
        this.modelContextBuilder = ModelContext.builder(klass);
    }

    public ClassCreationApi<T> withTypeParameters(Class<?>... type) {
        modelContextBuilder.withRootTypeParameters(Arrays.asList(type));
        return this;
    }

    @Override
    public ClassCreationApi<T> ignore(Binding binding) {
        if (binding.isFieldBinding()) {
            final Class<?> targetType = ObjectUtils.defaultIfNull(binding.getTargetType(), this.rootClass);
            modelContextBuilder.withIgnoredField(getField(targetType, binding.getFieldName()));
        } else {
            modelContextBuilder.withIgnoredClass(binding.getTargetType());
        }

        return this;
    }

    @Override
    public <V> ClassCreationApi<T> with(Binding binding, Generator<V> generator) {
        if (binding.isFieldBinding()) {
            final Class<?> targetType = ObjectUtils.defaultIfNull(binding.getTargetType(), this.rootClass);
            modelContextBuilder.withFieldGenerator(getField(targetType, binding.getFieldName()), generator);
        } else {
            modelContextBuilder.withClassGenerator(binding.getTargetType(), generator);
        }
        return this;
    }

    @Override
    public ClassCreationApi<T> withNullable(Binding target) {
        if (target.isFieldBinding()) {
            final Class<?> targetType = ObjectUtils.defaultIfNull(target.getTargetType(), this.rootClass);
            modelContextBuilder.withNullableField(getField(targetType, target.getFieldName()));
        } else {
            modelContextBuilder.withNullableClass(target.getTargetType());
        }
        return this;
    }


    @Override
    public ClassCreationApi<T> map(Class<?> baseClass, Class<?> subClass) {
        modelContextBuilder.withSubtypeMapping(baseClass, subClass);
        return this;
    }

    @Override
    public Model<T> toModel() {
        return createModel();
    }

    @Override
    public T create() {
        final InstancioDriver instancioDriver = new InstancioDriver(createModel());
        return instancioDriver.createEntryPoint();
    }

    private InternalModel<T> createModel() {
        return new InternalModel<>(modelContextBuilder.build());
    }
}
