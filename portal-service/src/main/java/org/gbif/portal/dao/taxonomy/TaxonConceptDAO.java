/***************************************************************************
 * Copyright (C) 2006 Global Biodiversity Information Facility Secretariat.
 * All Rights Reserved.
 * The contents of this file are subject to the Mozilla Public
 * License Version 1.1 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of
 * the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS
 * IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * rights and limitations under the License.
 ***************************************************************************/
package org.gbif.portal.dao.taxonomy;

import org.gbif.portal.model.taxonomy.CommonName;
import org.gbif.portal.model.taxonomy.TaxonConcept;
import org.gbif.portal.model.taxonomy.TaxonConceptLite;
import org.gbif.portal.model.taxonomy.TaxonRank;

import java.util.Date;
import java.util.List;

/**
 * The DAO for the TaxonConcept model object
 * 
 * @author dmartin
 */
public interface TaxonConceptDAO {

  /**
   * Counts the number of child concepts.
   * 
   * @param parentId
   * @param parentRank
   * @param childRank
   * @return count of the number of child concepts
   */
  public int countChildConcepts(long parentId, TaxonRank parentRank, TaxonRank childRank, boolean countSynonyms,
    boolean onlyCountAccepted, boolean allowUnconfirmed);

  /**
   * Counts concepts that match the supplied name.
   * 
   * @param nameStub the name to search for
   * @param fuzzy whether the search should use wildcards
   * @param dataProviderId the data provider to perform a count for, nullable
   * @param dataResourceId the data resource id to interrogate
   * @param resourceNetworkId the resource network id to interrogate
   * @param hostIsoCountryCode the ISO code for the country where the provider is based, nullable
   * @param modifiedSince only return records modified after this date, nullable
   * @return a count of concepts that match the partial name.
   */
  public Long countTaxonConcepts(String nameStub, boolean fuzzy, TaxonRank taxonRank, Long dataProviderId,
    Long dataResourceId, Long resourceNetworkId, String hostIsoCountryCode, Date modifiedSince);

  /**
   * Retrieves a list of concept that match the supplied name.
   * 
   * @param canonical the canonical name to search for
   * @param specificEphitet the specific ephitet to search for
   * @param fuzzy whether the search should use wildcards
   * @param dataProviderId the data provider to perform a count for, nullable
   * @param dataResourceId the data resource id to interrogate, nullable
   * @param resourceNetworkId the resource network id to interrogate, nullable
   * @param hostIsoCountryCode the ISO code for the country where the provider is based, nullable
   * @param modifiedSince only return records modified after this date, nullable
   * @param startIndex the index of the first result
   * @param maxResults the maximum number of results to return
   * @return a list of concepts that match the partial name.
   */
  public List<TaxonConcept> findTaxonConcepts(String canonical, String specificEphitet, boolean fuzzy,
    TaxonRank taxonRank, Long dataProviderId, Long dataResourceId, Long resourceNetworkId, String hostIsoCountryCode,
    Date modifiedSince, boolean allowUnconfirmed, boolean sortAlphabetically, int startIndex, int maxResults);

  /**
   * Find taxon concepts that are associated with the supplied common name.
   * 
   * @param commonNameStub
   * @param fuzzy
   * @param startIndex
   * @param maxResults
   * @return list of Taxon Concepts
   */
  public List<CommonName> findTaxonConceptsForCommonName(String commonNameStub, boolean fuzzy, int startIndex,
    int maxResults);

  /**
   * Finds concepts with the same canonical and rank.
   * 
   * @param taxonConceptId the id of the concept to find similar concepts for
   * @param startIndex the startIndex for these results
   * @param maxResults the maximum number of results to return
   * @return List of matching Taxon Concepts
   */
  public List<TaxonConcept> findTaxonConceptsWithSameCanonicalAndRankAs(long taxonConceptId, Long dataProviderId,
    Long dataResourceId, int startIndex, int maxResults);

  /**
   * Return the authoritative concepts associated with a nub taxon concept
   * 
   * @param nubConceptId
   * @return
   */
  public List<TaxonConcept> getAuthoritativeTaxonConceptsForNubTaxonConcept(Long nubConceptId);

  /**
   * Returns a list of Child Concepts for the Taxon Concept with the specified key value.
   * 
   * @param taxonConceptId The id of the taxonConcept
   * @return The Parent Concept object for the concept with this id.
   */
  public List<TaxonConcept> getChildConceptsFor(long taxonConceptId, boolean allowUnconfirmed);

  /**
   * Returns the root concepts for a country
   * 
   * @param isoCountryCode
   * @return the root concepts for a country
   */
  public List<TaxonConceptLite> getCountryRootConceptsFor(String isoCountryCode);

  /**
   * Finds root concepts for this Data Provider. These are root concepts without parent concepts.
   * 
   * @param dataProviderId the id of the Data Provider to query
   * @return a list of root concepts for this Data Provider
   */
  public List<TaxonConcept> getDataProviderRootConceptsFor(long dataProviderId);

  /**
   * Finds root concepts for this Data Resource. These are root concepts without parent concepts.
   * 
   * @param dataResourceId the id of the Data Resource to query
   * @return a list of root concepts for this Data Resource
   */
  public List<TaxonConcept> getDataResourceRootConceptsFor(long dataResourceId);

  /**
   * Returns the root concepts for a department
   * 
   * @param isoDepartmentCode
   * @return the root concepts for a department
   */
  public List<TaxonConceptLite> getDepartmentRootConceptsFor(String isoDepartmentCode);
  
  /**
   * Returns the root concepts for a county
   * 
   * @param isoCountyCode
   * @return the root concepts for a county
   */
  public List<TaxonConceptLite> getCountyRootConceptsFor(String isoCountyCode);
  
  /**
   * Returns the root concepts for a paramo
   * 
   * @param paramo
   * @return the root concepts for a paramo
   */
  public List<TaxonConceptLite> getParamoRootConceptsFor(String paramo);

  /**
   * A more populated TaxonConcept with eagerly loaded associations. This should be used
   * by service layer methods that need to access major rank concepts associated with a
   * concept.
   * 
   * @param taxonConceptId the id of the concept to load
   * @return a list of root concepts for this Data Resource
   */
  public TaxonConcept getDetailedTaxonConceptFor(long taxonConceptId);

  /**
   * Returns a list of Child Concepts for the Taxon Concept with the specified key value.
   * 
   * @param taxonConceptId The id of the taxonConcept
   * @param isoCountryCode Restrict search to concepts within the supplied country, nullable
   * @return The Parent Concept object for the concept with this id.
   */
  public List<TaxonConceptLite> getLiteChildConceptsFor(long taxonConceptId, String isoCountryCode,
    boolean allowUnconfirmed);

  /**
   * Returns a list of Child Concepts for the Taxon Concept with the specified key value.
   * 
   * @param taxonConceptId The id of the taxonConcept
   * @param isoDepartmentCode Restrict search to concepts within the supplied department, nullable
   * @return The Parent Concept object for the concept with this id.
   */
  public List<TaxonConceptLite> getLiteChildConceptsForDepartment(long taxonConceptId, String isoDepartmentCode,
    boolean allowUnconfirmed);
  
  /**
   * Returns a list of Child Concepts for the Taxon Concept with the specified key value.
   * 
   * @param taxonConceptId The id of the taxonConcept
   * @param isoCountyCode Restrict search to concepts within the supplied county, nullable
   * @return The Parent Concept object for the concept with this id.
   */
  public List<TaxonConceptLite> getLiteChildConceptsForCounty(long taxonConceptId, String isoCountyCode,
    boolean allowUnconfirmed);

  /**
   * Returns a list of Child Concepts for the Taxon Concept with the specified key value.
   * 
   * @param taxonConceptId The id of the taxonConcept
   * @param paramo Restrict search to concepts within the supplied paramo, nullable
   * @return The Parent Concept object for the concept with this id.
   */
  public List<TaxonConceptLite> getLiteChildConceptsForParamo(long taxonConceptId, String complexId,
    boolean allowUnconfirmed);

  /**
   * Returns the Nub Concept of the Taxon Concept with the specified key value.
   * 
   * @param taxonConceptId The id of the taxonConcept to find the nub concept for
   * @return The Nub Concept object for the concept with this id.
   */
  public TaxonConcept getNubConceptFor(long taxonConceptId);

  /**
   * Retrieves the concept specified by the supplied key and populates the reference to
   * parent its concept and child concepts. Hence accessing the Parent or Child Concept on the return TaxonConcept
   * will not result in a loading of the Parent Concept or Child concepts.
   * 
   * @param taxonConceptKey the id of the concept to load
   * @param retrieveChildren whether to retrieve the children of the concept specified by taxonConceptKey
   * @return List containing the concept specified by the key and its parent if the parent exists
   */
  public TaxonConcept getParentChildConcepts(long taxonConceptId, boolean retrieveChildren, boolean allowUnconfirmed);

  /**
   * Returns the Parent Concept of the Taxon Concept with the specified key value.
   * 
   * @param taxonConceptId The id of the taxonConcept
   * @return The Parent Concept object for the concept with this id.
   */
  public TaxonConcept getParentConceptFor(long taxonConceptId);

  /**
   * Retrieves a count for the number of concepts for a provider or resource.
   * 
   * @param dataProviderId
   * @param dataResourceId
   * @return a count of the number of concepts
   */
  public int getTaxonConceptCount(Long dataProviderId, Long dataResourceId);

  /**
   * Get a count of concepts with names matching. Supplying a null dataResourceId
   * will result in counting across taxonomies.
   * 
   * @param nameStub the partial name to search for
   * @param fuzzy whether the search should use wildcards
   * @param dataProviderId the data provider to perform a count for, nullable
   * @param dataResourceId the data resource to perform a count for, nullable
   * @return the concept count.
   */
  public int getTaxonConceptCount(String nameStub, boolean fuzzy, Long dataProviderId, Long dataResourceId);

  /**
   * Get a count of concepts with of specified rank. Supplying a null dataResourceId
   * will result in counting across taxonomies.
   * 
   * @param taxonRank the rank to search for, not nullable
   * @param higherThanSuppliedRank, nullable
   * @param dataProviderId the data provider to perform a count for, nullable
   * @param dataResourceId the data resource to perform a count for, nullable
   * @return the concept counts
   */
  public int getTaxonConceptCountForRank(TaxonRank taxonRank, Boolean higherThanSuppliedRank, Long dataProviderId,
    Long dataResourceId);

  /**
   * Returns the TaxonConcept with the specified id value.
   * 
   * @param taxonConceptId The id of the taxonConcept
   * @return The TaxonConcept object for this id.
   */
  public TaxonConcept getTaxonConceptFor(long taxonConceptId);

  /**
   * Retrieves a concept for the remote identifier.
   * 
   * @param dataProviderId
   * @param dataResourceId
   * @param remoteId
   * @return a taxon concept for this remote id
   */
  public TaxonConcept getTaxonConceptForRemoteId(Long dataProviderId, Long dataResourceId, String remoteId);

  /**
   * Returns the Taxon Concepts with the specified remote id value.
   * 
   * @param remoteConceptId The remote id of one or more taxonConcept
   * @return List of TaxonConcepts for this remote id.
   */
  public List<TaxonConcept> getTaxonConceptForRemoteId(String remoteConceptId);

  /**
   * Returns the Taxon Concept Ids identified as corresponding to the identified Nub Concept.
   * 
   * @param nubConceptId The id of the nub concept for which to find taxon concepts.
   * @return The Nub Concept object for the concept with this id.
   */
  public List<Long> getTaxonConceptIdsForNubTaxonConcept(long nubConceptId);

  /**
   * Returns the lite version of TaxonConcept.
   * 
   * @param taxonConceptId
   * @return The TaxonConceptLite object for this id.
   */
  public TaxonConceptLite getTaxonConceptLiteFor(long taxonConceptId);

  /**
   * Returns the Taxon Concepts identified as corresponding to the identified Nub Concept.
   * 
   * @param nubConceptId The id of the nub concept for which to find taxon concepts.
   * @return The Nub Concept object for the concept with this id.
   */
  public List<TaxonConcept> getTaxonConceptsForNubTaxonConcept(long nubConceptId);
}