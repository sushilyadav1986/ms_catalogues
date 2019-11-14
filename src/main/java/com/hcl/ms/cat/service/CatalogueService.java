package com.hcl.ms.cat.service;

import com.hcl.ms.cat.entity.Catalogue;
import com.hcl.ms.cat.model.CatalogueModel;

/** Create custom Interface
 *  Communicate between Controller and Service
 * @author SushilY
 *
 */
public interface CatalogueService {
	
	/**
	 * Save Catalogue Details in respected Table
	 * Fetch save Obj From Table
	 * @param catalogueModel 
	 * @return 
	 */
	Catalogue addCatalogue(CatalogueModel catalogueModel);

}
