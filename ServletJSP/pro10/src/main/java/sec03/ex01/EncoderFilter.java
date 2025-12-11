package sec03.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncoderFilter
 */
@WebFilter("/*")
public class EncoderFilter extends HttpFilter implements Filter {
	ServletContext context;

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public EncoderFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String context = ((HttpServletRequest) request).getContextPath();
		String pathinfo = ((HttpServletRequest) request).getRequestURI();
		String realPath = ((HttpServletRequest) request).getRealPath(pathinfo);

		String msg = "context 정보:" + context + "URI정보: " + pathinfo + "물리적 경로:" + realPath;
		System.out.println(msg);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		context = fConfig.getServletContext();
	}

}
