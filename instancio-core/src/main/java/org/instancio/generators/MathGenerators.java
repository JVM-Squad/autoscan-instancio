/*
 * Copyright 2022-2025 the original author or authors.
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
package org.instancio.generators;

import org.instancio.generator.specs.BigDecimalGeneratorSpec;
import org.instancio.generator.specs.NumberGeneratorSpec;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Contains built-in generators for {@code java.math} classes.
 */
public interface MathGenerators {

    /**
     * Customises generated {@link BigInteger} values.
     *
     * @return API builder reference
     */
    NumberGeneratorSpec<BigInteger> bigInteger();

    /**
     * Customises generated {@link BigDecimal} values.
     *
     * <p>The spec provides two options for customising generated values:
     *
     * <ul>
     *   <li>Using the {@code min(BigDecimal)}, {@code max(BigDecimal}}, or
     *       {@code range(BigDecimal, BigDecimal)} methods</li>
     *   <li>Using the {@code precision(int)} method</li>
     * </ul>
     *
     * <p>See {@link BigDecimalGeneratorSpec#precision(int)} for details.
     *
     * @return API builder reference
     */
    BigDecimalGeneratorSpec bigDecimal();
}
