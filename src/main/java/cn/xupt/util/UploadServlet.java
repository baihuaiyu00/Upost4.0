//package cn.xupt.util;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.jsp.JspFactory;
//import javax.servlet.jsp.PageContext;
//
//import com.jspsmart.upload.SmartUpload;
//import com.jspsmart.upload.SmartUploadException;
//
//public class UploadServlet extends HttpServlet {
//
//
//	/**
//	 *
//	 */
//	private static final long serialVersionUID = 1L;
//
//
//	public UploadServlet() {
//		super();
//	}
//
//
//	public void destroy() {
//		super.destroy(); // Just puts "destroy" string in log
//		// Put your code here
//	}
//
//
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doPost(request,response);
//	}
//
//
//	public void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
////		request.setCharacterEncoding("UTF-8");
////
////		response.setContentType("text/html;charset=UTF-8");
//		//ʵ��������bean
//		PrintWriter out = response.getWriter();
//		SmartUpload mySmartUpload = new SmartUpload();
//		//PageContext��jsp�����ö�����servlet����ֱ��ʹ��
//		JspFactory jspFactory = JspFactory.getDefaultFactory();
//		PageContext pageContext = jspFactory.getPageContext(this, request, response, "",true, 8192, true);
//		//��ʼ��
//		mySmartUpload.initialize(pageContext);
//		//�������ص����ֵ��ע�⣺������ù�����������
//		mySmartUpload.setMaxFileSize(10*1024*1024);
//		//�����ļ�
//		try{
//			mySmartUpload.upload();
//		}  catch (SmartUploadException e)
//        {
//            e.printStackTrace();
//        }
//
//        // ȡ�����ص��ļ�
//        com.jspsmart.upload.File myFile = mySmartUpload.getFiles().getFile(0);
//        if (!myFile.isMissing())
//        {
//            // ȡ�ñ�Ĳ���
//            String play_type = (String) mySmartUpload.getRequest().getParameter("play_type");
//            String play_lang = (String) mySmartUpload.getRequest().getParameter("play_lang");
//            String play_name = (String) mySmartUpload.getRequest().getParameter("play_name");
//            String play_introduction = (String) mySmartUpload.getRequest().getParameter("play_introduce");
//            String play_length = (String) mySmartUpload.getRequest().getParameter("play_length");
//            String play_ticket_price = (String) mySmartUpload.getRequest().getParameter("play_ticket_price");
//
//            // ȡ�����ص��ļ����ļ���
//            String myFileName = myFile.getFileName();
//            // ȡ�ò�����׺���ļ���
//            String suffix = myFileName.substring(0, myFileName.lastIndexOf('.'));
//            // ȡ�ú�׺��
//            String ext = myFile.getFileExt();
//            // ȡ���ļ��Ĵ�С
//            int fileSize = myFile.getSize();
//            // ����·��
//            String aa = getServletContext().getRealPath("/") + "jsp\\";
//            File aadir = new File(aa);
//            if (!aadir.exists())
//                aadir.mkdirs();
//            String trace = aa + myFileName;
//            System.out.println("*****"+trace);
//            System.out.println(trace);
//            // ���ļ������ڷ�������(ʹ��ȫ·��)
//            try
//            {
//                myFile.saveAs(trace, mySmartUpload.SAVE_PHYSICAL);
//            }
//            catch (SmartUploadException e)
//            {
//                e.printStackTrace();
//            }
//
//            // ���ϴ��������ļ�·������vo��
//            Play play = new Play();
//            play.setPlayName(play_name);
//            play.setPlayType(play_type);
//            play.setPlayLang(play_lang);
//            play.setPlayIntroduce(play_introduction);
//            play.setPlayLength(Integer.parseInt(play_length));
//            play.setPlayTicketPrice(Float.parseFloat(play_ticket_price));
//            // ֻ�������·��
//            play.setPlayImage("jsp\\" + myFileName);
//            String result = "/results.jsp";
//            out.print("<a href="+trace+">"+trace+"</a><br/>");
//            out.print("<a href="+result+">"+trace+"</a><br/>");
//
//
//        }
//    }
//
//
//
//	public void init() throws ServletException {
//		// Put your code here
//	}
//
//}
