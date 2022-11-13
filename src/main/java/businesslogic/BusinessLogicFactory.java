package businesslogic;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import configuration.ConfigXML;
import dataaccess.DataAccess;

public class BusinessLogicFactory {

    public BLFacade createFacadeInterface(boolean isLocal, ConfigXML c) {
        if(isLocal) {
            DataAccess da= new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
            BLFacadeImplementation appFacadeInterface=new BLFacadeImplementation(da);
            return appFacadeInterface;
        }
        else {
           try{
               String serviceName= "http://"+c.getBusinessLogicNode() +":"+ c.getBusinessLogicPort()+"/ws/"+c.getBusinessLogicName()+"?wsdl";
                URL url = new URL(serviceName);
                QName qname = new QName("http://businesslogic/", "BLFacadeImplementationService");
                Service service = Service.create(url, qname);
                BLFacade appFacadeInterface = service.getPort(BLFacade.class);
                return appFacadeInterface;
           }
           catch(Exception e) {
               return null;
           }	
        }
    }
}
