package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import po.Customer;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
		System.out.println("afterCompletion");
//		// TODO Auto-generated method stub
//		System.out.println("afterCompletion..");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("postHandle");
//		// TODO Auto-generated method stub
//		System.out.println("postHandle..");
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
		
		System.out.println("preHandle");
		HttpSession sen = req.getSession(false);
		
		if(sen == null)
		{	
			resp.sendRedirect("logout");
			return false;
		}
		else
		{
			boolean isLogin = (boolean)sen.getAttribute("isLogin");
			if(!isLogin)
			{
				resp.sendRedirect("logout");
				return false;
			}
		}
		return true;
		
		
		// TODO Auto-generated method stub
//		HttpSession session = arg0.getSession();
//		if(session.getAttribute("customer001") == null)
//		{
//			arg1.sendRedirect("login.jsp");
//			return false;
//		}
//		return true;
	}

}
