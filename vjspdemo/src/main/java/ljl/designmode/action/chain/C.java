package ljl.designmode.action.chain;

import org.hibernate.validator.internal.util.classhierarchy.Filters;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Title: C
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/21 10:25
 */
class MyFilter1 implements Filter {

	@Override public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("MyFilter1 execute");
		filterChain.doFilter(servletRequest,servletResponse);
	}

	@Override public void destroy() {

	}
}
class MyFilter2 implements Filter {

	@Override public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("MyFilter2 execute");
		filterChain.doFilter(servletRequest,servletResponse);
	}

	@Override public void destroy() {

	}
}
class MyFilterChain implements FilterChain{
    private List<Filter> filters;
    private int pos;

	public MyFilterChain(){
		this.filters= new ArrayList<Filter>();
		pos=0;
	}
	public void addFilter(Filter filter){
		filters.add(filter);

	}
	@Override public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse)
			throws IOException, ServletException {
		if(pos<filters.size()){
			this.filters.get(pos++).doFilter(servletRequest,servletResponse,this);
		}
	}
}
public class C {
	public static void main(String[] args) throws Exception{
		Filter f1 = new MyFilter1();
		Filter f2 = new MyFilter2();
		Filter f3 = new MyFilter2();
		MyFilterChain filterChain = new MyFilterChain();
		filterChain.addFilter(f1);
		filterChain.addFilter(f2);
		filterChain.addFilter(f3);
		filterChain.doFilter(null,null);
	}
}
