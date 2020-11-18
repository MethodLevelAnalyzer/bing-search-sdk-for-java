/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.bing.visualsearch.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response base.
 */
public class ResponseBase {
    /**
     * The _type property.
     */
    @JsonProperty(value = "_type")
    private String _type;

    /**
     * Get the _type value.
     *
     * @return the _type value
     */
    public String _type() {
        return this._type;
    }

    /**
     * Set the _type value.
     *
     * @param _type the _type value to set
     * @return the ResponseBase object itself.
     */
    public ResponseBase with_type(String _type) {
        this._type = _type;
        return this;
    }

}
