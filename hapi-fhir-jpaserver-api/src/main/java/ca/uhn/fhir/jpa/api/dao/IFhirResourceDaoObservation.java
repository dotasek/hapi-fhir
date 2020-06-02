package ca.uhn.fhir.jpa.api.dao;

import ca.uhn.fhir.jpa.searchparam.SearchParameterMap;
import ca.uhn.fhir.rest.api.server.IBundleProvider;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import org.hl7.fhir.instance.model.api.IBaseResource;

import javax.servlet.http.HttpServletResponse;

/*
 * #%L
 * HAPI FHIR JPA Server
 * %%
 * Copyright (C) 2014 - 2020 University Health Network
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

public interface IFhirResourceDaoObservation<T extends IBaseResource> extends IFhirResourceDao<T> {

	/**
	 * Returns a BundleProvider which can be used to implement the $lastn operation.
	 * @param paramMap Parameters supported include Observation.subject, Observation.patient, Observation.code,
	 *                 Observation.category, and max (the maximum number of Observations to return per specified subjects/patients,
	 *                 codes, and/or categories.
	 * @param theRequestDetails
	 * @param theServletResponse
	 * @return
	 */
	IBundleProvider observationsLastN(SearchParameterMap paramMap, RequestDetails theRequestDetails, HttpServletResponse theServletResponse);

}