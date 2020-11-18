/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.bing.imagesearch.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines a list of previously recognized entities.
 */
public class RecognizedEntitiesModule {
    /**
     * A list of recognized entities.
     */
    @JsonProperty(value = "value", access = JsonProperty.Access.WRITE_ONLY)
    private List<RecognizedEntityGroup> value;

    /**
     * Get a list of recognized entities.
     *
     * @return the value value
     */
    public List<RecognizedEntityGroup> value() {
        return this.value;
    }

}
