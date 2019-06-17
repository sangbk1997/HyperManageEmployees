//package hyperlogy.admin.user.config;
//
//import com.hyperlogy.framework.security.base.HyperVirtualHost;
//import com.hyperlogy.framework.util.ObjectContext;
//import org.jasig.cas.client.util.CommonUtils;
//import org.springframework.security.cas.ServiceProperties;
//import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * User: tronghh
// * Date: 5/23/13
// * Time: 11:47 PM
// */
//
//public class HyperCasLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
//    private ServiceProperties serviceProperties;
//
//    @Override
//    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
//        HyperVirtualHost virtualHost = ObjectContext.getContext(HyperVirtualHost.class).get();
//        String serviceUrl = CommonUtils.constructServiceUrl(null, response, serviceProperties.getService(), null, serviceProperties.getArtifactParameter(), false);
//        return CommonUtils.constructRedirectUrl(virtualHost.getSsoUrl() + getDefaultTargetUrl(), serviceProperties.getServiceParameter(), serviceUrl.replace(HyperCas20ServiceTicketValidator.CAS_SERVER_URL_ALIAS, virtualHost.getCallbackService()), serviceProperties.isSendRenew(), false);
//    }
//
//    public ServiceProperties getServiceProperties() {
//        return serviceProperties;
//    }
//
//    public void setServiceProperties(ServiceProperties serviceProperties) {
//        this.serviceProperties = serviceProperties;
//    }
//}
