package fri.uni_lj.si.teamManagementService.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class TeamManagementInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(TeamManagementInterceptor.class);
    private static final String UNIQUE_REQUEST = "uniqueRequestId";


    @Value("${spring.application.name}")
    String appName;

    @Value("${env.type}")
    String envType;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UUID reqId = UUID.randomUUID();
        request.setAttribute(UNIQUE_REQUEST, reqId);
        logger.info(appName + " :: " + envType + " :: ENTRY :: " + request.getMethod() + " :: " + request.getRequestURI() + " :: " + reqId );
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info(appName + " :: " + envType + " :: EXIT :: " + request.getMethod() + " :: " + request.getRequestURI() + " :: " + request.getAttribute(UNIQUE_REQUEST));
    }
}