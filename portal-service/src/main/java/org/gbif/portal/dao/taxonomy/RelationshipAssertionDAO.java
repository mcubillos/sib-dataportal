/***************************************************************************
 * Copyright (C) 2005 Global Biodiversity Information Facility Secretariat.  
 * All Rights Reserved.
 *
 * The contents of this file are subject to the Mozilla Public
 * License Version 1.1 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of
 * the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS
 * IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * rights and limitations under the License.
 ***************************************************************************/
package org.gbif.portal.dao.taxonomy;

import java.util.List;

import org.gbif.portal.model.taxonomy.RelationshipAssertion;

/**
 * DAO for RelationshipAssertion objects.
 * 
 * @author Donald Hobern
 */
public interface RelationshipAssertionDAO {
	
	/**
	 * Retrieves the relationship assertion for the supplied from concept id.
	 * @param fromTaxonConceptId
	 * @return List of RelationshipAssertion objects
	 */
	public List<RelationshipAssertion> getRelationshipAssertionsForFromTaxonConcept(long fromTaxonConceptId);

	/**
	 * Retrieves the relationship assertion for the supplied to concept id.
	 * @param toTaxonConceptId
	 * @return List of RelationshipAssertion objects
	 */
	public List<RelationshipAssertion> getRelationshipAssertionsForToTaxonConcept(long toTaxonConceptId);

}