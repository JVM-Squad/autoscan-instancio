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
package org.instancio.test.features.assign;

import org.instancio.Instancio;
import org.instancio.junit.InstancioExtension;
import org.instancio.test.support.pojo.misc.StringFields;
import org.instancio.test.support.tags.Feature;
import org.instancio.test.support.tags.FeatureTag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.instancio.Assign.given;
import static org.instancio.Select.field;

@FeatureTag(Feature.ASSIGN)
@ExtendWith(InstancioExtension.class)
class AssignWithUnmatchedOriginValueTest {

    /**
     * Although origin value is not matched, this should not throw
     * unused selector exception.
     */
    @Test
    void unmatched() {
        final String unmatchedOriginValue = Instancio.gen().string().length(20).get();
        final String destinationValue = "2";

        final StringFields result = Instancio.of(StringFields.class)
                .assign(given(StringFields::getOne)
                        .is(unmatchedOriginValue)
                        .set(field(StringFields::getTwo), destinationValue))
                .create();

        assertThat(result.getOne()).isNotEqualTo(unmatchedOriginValue);
        assertThat(result.getTwo()).isNotEqualTo(destinationValue);
    }
}
