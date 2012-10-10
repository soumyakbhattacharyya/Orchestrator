/**
 * Copyright 2012 Soumyak Bhattacharyya
 * This project includes software developed by Soumyak Bhattacharyya: https://github.com/iamsoumyak
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * 
 */
package com.cognizant.util.resource;

import java.util.List;

import org.apache.commons.collections.ListUtils;



/**
 * @author 239913
 *
 */
public abstract class AbstractResourceManager implements IResourceManager {

	/* (non-Javadoc)
	 * @see com.cognizant.util.resource.IResourceManager#spawnVM()
	 */
	@Override
	public boolean spawnVM() {
		// TODO Auto-generated method stub
		return HAS_SPAWNED;
	}

	/* (non-Javadoc)
	 * @see com.cognizant.util.resource.IResourceManager#stopVM()
	 */
	@Override
	public boolean stopVM() {
		// TODO Auto-generated method stub
		return HAS_TERMINATED;
	}

	/* (non-Javadoc)
	 * @see com.cognizant.util.resource.IResourceManager#getVM()
	 */
	@Override
	public List getVM() {
		// TODO Auto-generated method stub
		return ListUtils.EMPTY_LIST;
	}

}
