/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.bing.autosuggest.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The SuggestionsSuggestionGroup model.
 */
public class SuggestionsSuggestionGroup {
    /**
     * Possible values include: 'Unknown', 'Web', 'StoreApps', 'SearchHistory',
     * 'PersonalSearchDocuments', 'PersonalSearchTags', 'Custom'.
     */
    @JsonProperty(value = "name", required = true)
    private ScenarioType name;

    /**
     * The searchSuggestions property.
     */
    @JsonProperty(value = "searchSuggestions", required = true)
    private List<SearchAction> searchSuggestions;

    /**
     * The _type property.
     */
    @JsonProperty(value = "_type")
    private String _type;

    /**
     * Get possible values include: 'Unknown', 'Web', 'StoreApps', 'SearchHistory', 'PersonalSearchDocuments', 'PersonalSearchTags', 'Custom'.
     *
     * @return the name value
     */
    public ScenarioType name() {
        return this.name;
    }

    /**
     * Set possible values include: 'Unknown', 'Web', 'StoreApps', 'SearchHistory', 'PersonalSearchDocuments', 'PersonalSearchTags', 'Custom'.
     *
     * @param name the name value to set
     * @return the SuggestionsSuggestionGroup object itself.
     */
    public SuggestionsSuggestionGroup withName(ScenarioType name) {
        this.name = name;
        return this;
    }

    /**
     * Get the searchSuggestions value.
     *
     * @return the searchSuggestions value
     */
    public List<SearchAction> searchSuggestions() {
        return this.searchSuggestions;
    }

    /**
     * Set the searchSuggestions value.
     *
     * @param searchSuggestions the searchSuggestions value to set
     * @return the SuggestionsSuggestionGroup object itself.
     */
    public SuggestionsSuggestionGroup withSearchSuggestions(List<SearchAction> searchSuggestions) {
        this.searchSuggestions = searchSuggestions;
        return this;
    }

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
     * @return the SuggestionsSuggestionGroup object itself.
     */
    public SuggestionsSuggestionGroup with_type(String _type) {
        this._type = _type;
        return this;
    }

}
