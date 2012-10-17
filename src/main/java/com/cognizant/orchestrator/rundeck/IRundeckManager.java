/*
 * Copyright 2012 Cognizant.
 *
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
 */
package com.cognizant.orchestrator.rundeck;

import java.util.List;
import org.rundeck.api.RundeckClient;
import org.rundeck.api.domain.RundeckExecution;
import org.rundeck.api.domain.RundeckJob;
import org.rundeck.api.domain.RundeckProject;

/**
 *
 * @author Cognizant
 */
public interface IRundeckManager {
    
    /*
     * For localhost
     */
    RundeckClient connectLocal();
    
    /*
     * For remote host
     */
    RundeckClient connectRemote();
    
    /*
     * Get projects
     */
    List<RundeckProject> getProjects();
    
    /*
     * Get a job
     */
    RundeckJob getJob();
    
    /*
     * Trigger a job 
     */
    RundeckExecution trigger();
    
    
}
