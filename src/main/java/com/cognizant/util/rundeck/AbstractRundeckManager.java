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
package com.cognizant.util.rundeck;

import com.cognizant.httpsclientutil.HttpsClientFactory;
import com.cognizant.httpsclientutil.HttpsClientUtil;
import com.cognizant.httpsclientutil.HttpsSSLException;
import com.cognizant.jpaas.cloud.client.JPaaSCloudAccess;
import com.cognizant.jpaas.cloud.client.ProviderContextInitializer;
import com.cognizant.jpaas.cloud.datamodel.cloud.VirtualMachineProductType;
import com.cognizant.jpaas.cloud.datamodel.cloud.VirtualMachineType;
import com.cognizant.jpaas.cloud.exception.PlatformException;

import java.io.File;
import java.util.List;
import org.jdom.input.SAXBuilder;
import org.rundeck.api.OptionsBuilder;
import org.rundeck.api.RundeckClient;
import org.rundeck.api.domain.RundeckExecution;
import org.rundeck.api.domain.RundeckJob;
import org.rundeck.api.domain.RundeckProject;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author Cognizant
 */
public abstract class AbstractRundeckManager implements IRundeckManager {

    private static String machineimage = "https://10.227.125.43:8243/services/MachineImageSoapServiceService";
    private static String virtualmachine = "https://10.227.125.43:8243/services/VirtualMachineSoapServiceService";

    public static void main(String[] args) throws InterruptedException {
        //spawn();
        upsertResource();        
        Thread.sleep(5000);
        upsertTag();
        Thread.sleep(5000);        
        fire();
    }

    private static void spawn() {

        HttpsClientUtil util = HttpsClientFactory.getHttpsClientUtil();
        try {
            util.setSSLEnvironment(
                    "D:/sb/JPaaS2.0 - keys - (ppk-priv)/JPaaS-Integration/Cognizant-JPaaS2-dev-1.0.jks",
                    "Cognizant-JPaaS");
        } catch (HttpsSSLException e1) {
            System.out.println(e1);
        }

        ProviderContextInitializer
                .initProviderContext("D:/sb/work/workspace/JPaaSInfraServiceClient/src/main/resources/euca-provider-context-properties");
        JPaaSCloudAccess jPaaSCloudAccess = new JPaaSCloudAccess();

        VirtualMachineProductType product = new VirtualMachineProductType();
        //product.setCpuCount(1);
        product.setProductId("m1.small");
        //product.setDiskSizeInGb(1);
        product.setName("test-vm-launch");
        //product.setRamInMb(2097152);

        try {
            VirtualMachineType machineType = jPaaSCloudAccess.launchVirtualMachine("BaaS",
                    "emi-089B1616", product, null, "test-vm-launch",
                    "test for private addressing", "JPaaS-Testing", null, false, false, null,
                    virtualmachine, null);
            System.out.println(machineType);
        } catch (PlatformException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void upsertResource() {
        
        try {
 
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File("D:\\sb\\tool\\apache-tomcat-7.0.27\\webapps\\jabox-0.4.0-jetty-console\\resources.xml");
 
		Document doc = (Document) builder.build(xmlFile);
		Element rootNode = doc.getRootElement();
 
		// update staff id attribute
		List nodes = rootNode.getChildren();
                
                for(int i = 0; i < nodes.size(); i++){
                
                 System.out.println(((Element)nodes.get(i)).toString());
                 Element e = (Element)nodes.get(i);
                 System.out.println(e.getAttribute("name"));
                 if(e.getAttribute("name").getValue().equals("slave_at_47")){
                  e.getAttribute("tags").setValue("i-43E907F1");
                 }
                }
                
                
                //System.out.println(node1.getAttribute("name").getValue());
		//if(node1.getAttribute("name").getValue().equals("slave_at_47")){
                //node1.getAttribute("tags").setValue("i-43E907F1");
                //}
                
                // update staff id attribute
		//Element node2 = rootNode.getChild("node");
                //System.out.println(node2.getAttribute("name").getValue());
		//if(node2.getAttribute("name").getValue().equals("slave_at_47")){
                //node2.getAttribute("tags").setValue("i-43E907F1");
                //}
 
		XMLOutputter xmlOutput = new XMLOutputter();
 
		// display nice nice
		xmlOutput.setFormat(Format.getPrettyFormat());
		xmlOutput.output(doc, new FileWriter("D:\\sb\\tool\\apache-tomcat-7.0.27\\webapps\\jabox-0.4.0-jetty-console\\resources.xml"));
 
		// xmlOutput.output(doc, System.out);
 
		System.out.println("File updated!");
	  } catch (IOException io) {
		io.printStackTrace();
	  } catch (JDOMException e) {
		e.printStackTrace();
	  }
	}
        
    

    private static void upsertTag() {
        
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/rundeckdb";
        String user = "root";
        String password = "root";
        String val = "i-43E907F1";

        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            int i = st.executeUpdate("UPDATE scheduled_execution set node_include_tags = 'i-43E907F1' where uuid='2ab29ecd-c58a-40d5-b503-05791bc3e4a0' AND workflow_id=2;"); 
                    
           System.out.println("This many rows updated "+i);                     
                    

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }    
    }

    private static void fire() throws InterruptedException {

        // using login-based authentication :
        RundeckClient rundeck = new RundeckClient("http://localhost:4440", "admin", "admin");

        // get projects
        List<RundeckProject> projects = rundeck.getProjects();

        System.out.println(projects);

        // get a specific job
        RundeckJob job = rundeck.findJob("webapp_deployer", "app_deployment", "webserver_util");

        System.out.println(job.toString());


        RundeckExecution execution = rundeck.runJob(job.getId());
//                , (new OptionsBuilder()
//                .addOption("rundeck.remote.home", "/home/ubuntu/rdeck_base")
//                .addOption("web.server.http.port", "8989")
//                .addOption("web.server.https.port", "7777")
//                .addOption("web.server.name", "56565")
//                .addOption("web.server.version", "1234")).toProperties());

        
   }
}