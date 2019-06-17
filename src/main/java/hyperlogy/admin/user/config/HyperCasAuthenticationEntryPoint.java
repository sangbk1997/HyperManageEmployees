//package hyperlogy.admin.user.config;
//
//import com.hyperlogy.framework.security.base.HyperVirtualHost;
//import com.hyperlogy.framework.util.ObjectContext;
//import org.jasig.cas.client.util.CommonUtils;
//import org.springframework.security.cas.web.CasAuthenticationEntryPoint;
//
///**
// * User: tronghh
// * Date: 5/23/13
// * Time: 11:27 PM
// */
//
//public class HyperCasAuthenticationEntryPoint extends CasAuthenticationEntryPoint {
//
//    /**
//     * Constructs the Url for Redirection to the CAS server.  Default implementation relies on the CAS client to do the bulk of the work.
//     *
//     * @param serviceUrl the service url that should be included.
//     * @return the redirect url.  CANNOT be NULL.
//     */
//
//    protected String createRedirectUrl(final String serviceUrl) {
//        HyperVirtualHost virtualHost = ObjectContext.getContext(HyperVirtualHost.class).get();
//        return CommonUtils.constructRedirectUrl(virtualHost.getSsoUrl() + getLoginUrl(), getServiceProperties().getServiceParameter(), serviceUrl.replace(HyperCas20ServiceTicketValidator.CAS_SERVER_URL_ALIAS, virtualHost.getCallbackService()), getServiceProperties().isSendRenew(), false);
//    }
//}
