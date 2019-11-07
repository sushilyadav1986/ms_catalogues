package com.hcl.ms.cat.service;

import com.hcl.ms.cat.entity.Catalogue;
import com.hcl.ms.cat.model.CatalogueModel;

/** Create custom Interface
 *  Communicate between Controller and Service
 * @author SushilY
 *
 */
public interface ICatalogueService {
	
	/**
	 * @param catalogueModel
	 * @return Catalogue
	 */
	Catalogue addCatalogue(CatalogueModel catalogueModel);

}
