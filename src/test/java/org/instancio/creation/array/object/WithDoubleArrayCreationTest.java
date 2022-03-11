package org.instancio.creation.array.object;

import org.instancio.pojo.arrays.object.WithDoubleArray;
import org.instancio.testsupport.tags.NonDeterministicTag;
import org.instancio.testsupport.templates.ArrayCreationTestTemplate;
import org.instancio.testsupport.templates.NumberOfExecutions;
import org.instancio.testsupport.utils.ArrayUtils;

public class WithDoubleArrayCreationTest extends ArrayCreationTestTemplate<WithDoubleArray> {

    @Override
    @NonDeterministicTag
    @NumberOfExecutions
    protected void verify(WithDoubleArray result) {
        generatedValues.addAll(ArrayUtils.toList(result.getValues()));
    }

}
