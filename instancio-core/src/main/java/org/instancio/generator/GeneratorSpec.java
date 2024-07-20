/*
 * Copyright 2022-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.instancio.generator;

/**
 * A marker interface serving as the base class
 * for all {@link Generator Generators}.
 *
 * <p>This interface does not expose any methods to the public API.
 * It is used to categorise and provide a common type for all
 * generator implementations.
 *
 * @param <T> the type of object generated by the implementing generator
 * @since 1.0.1
 */
@SuppressWarnings("unused")
public interface GeneratorSpec<T> {
}
