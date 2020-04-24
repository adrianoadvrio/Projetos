package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.jasper.runtime.JspWriterImpl;

public class TagCursoJsp extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		
	JspWriter out = getJspContext().getOut();
	out.println("Tag jsp customizada dificil tem que estudar isso");
	}
	

}
