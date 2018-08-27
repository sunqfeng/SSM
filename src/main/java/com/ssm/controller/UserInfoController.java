package com.ssm.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.model.LogMsg;
import com.ssm.service.UserInfoService;

/*****************************************************
 * 
 * 该文件中的所有函数主要控制页面之间跳转，逻辑处理判断尽量放在service 层进行处理
 * 
 * @author sunqifeng
 *
 *****************************************************/

@Controller
@RequestMapping("/UserInfoControl")
public class UserInfoController
{

	// 定义生成图片的变量
	private String code; //全局变量保存验证码
	private int width = 90;// 定义图片的width
	private int height = 20;// 定义图片的height
	private int codeCount = 4;// 定义图片上显示验证码的个数
	private int xx = 15;
	private int fontHeight = 18;
	private int codeY = 16;
	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };


	@Autowired /* 自动注入，这样下面 的 userinfoservice 就可以调用相应的函数了，否则你需要new UserInfoService的对象 */
	private UserInfoService userinfoservice;
	/**
	 * 转向登陆页
	 * 
	 * @return
	 */
	@RequestMapping("/tologin")
	public String toLogin()
	{
		return "login";
	}

	/**
	 * 
	 * 登录到注册页面
	 * 
	 * @return
	 */
	@RequestMapping("/zhuce")
	public String zhuce(Model model)
	{

		return "zhuce";// 用户注册页面
	}

	/**
	 * 展示登陆页;检查用户名、密码、验证码是否正确
	 * 
	 * @return
	 */
	@RequestMapping("/CheckUserInfo")
	@NotNull
	public String checkuserinfo(HttpServletRequest request, Model model)
	{

		LogMsg logmsg = new LogMsg();
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String yzm = request.getParameter("yzm");

		if( !yzm.equalsIgnoreCase(code) ) //判断验证码是否正确
		{
			logmsg.setCode("1102");
			logmsg.setMsg("验证码错误");
			model.addAttribute("logmsg", logmsg);
			return "login";
		}

		logmsg = userinfoservice.UserInfoAllService(name, pwd);// 判断客户用户名，密码是否正确
		model.addAttribute("logmsg", logmsg);
		if (!logmsg.getCode().equals("0"))
		{
			// return "error";
			return "login";
		} else
		{
			return "welcome";
		}
	}

	/**
	 * 注册用户数据到数据库
	 * 
	 */
	@RequestMapping("/zhuceyh")
	@NotNull
	public String zhuceyh(HttpServletRequest request, Model model)
	{
		LogMsg logmsg = new LogMsg();
		//鉴于前端水平有限,逻辑判断都放在后台了 ==!
		if(request.getParameter("telephone") == null ||
			request.getParameter("password") == null ||
			request.getParameter("name") == null )
		{
			logmsg.setCode("1101");
			logmsg.setMsg("为空时直接跳转到注册原始页面");
			return "zhuce";
		}

		logmsg = userinfoservice.zhuceyhservice(request);// 注册操作(姓名、密码插入表userinfo)
		if (!logmsg.getCode().equals("0"))
		{
			model.addAttribute("logmsg", logmsg); //报文信息返回前台
			return "zhuce";//注册失败则重新跳转到注册界面
		} 
		else
		{
			return "login"; // 注册成功后直接跳转到登录界面
		}
	}

	/**
	 * 生成验证码
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/yzm")
	public void yzm( HttpServletRequest request,HttpServletResponse resp,Model model ) throws IOException
	{
		// 定义图像buffer
		BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics gd = buffImg.getGraphics();
		// 创建一个随机数生成器类
		Random random = new Random();
		// 将图像填充为白色
		gd.setColor(Color.WHITE);
		gd.fillRect(0, 0, width, height);
		// 创建字体，字体的大小应该根据图片的高度来定。
		Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
		// 设置字体。
		gd.setFont(font);
		// 画边框。
		gd.setColor(Color.BLACK);
		gd.drawRect(0, 0, width - 1, height - 1);
		// 随机产生40条干扰线，使图象中的认证码不易被其它程序探测到。
		gd.setColor(Color.BLACK);
		for (int i = 0; i < 35; i++)
		{
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			gd.drawLine(x, y, x + xl, y + yl);
		}
		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;
		// 随机产生codeCount数字的验证码。
		for (int i = 0; i < codeCount; i++)
		{
			// 得到随机产生的验证码数字。
			String code = String.valueOf(codeSequence[random.nextInt(codeSequence.length - 1)]);
			// 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			// 用随机产生的颜色将验证码绘制到图像中。
			gd.setColor(new Color(red, green, blue));
			gd.drawString(code, (i + 1) * xx, codeY);
			// 将产生的四个随机数组合在一起。
			randomCode.append(code);
		}
		// 将四位数字的验证码保存到Session中。
		HttpSession session = request.getSession();
		session.setAttribute("code", randomCode.toString());
		code = randomCode.toString();//生成验证码

		// 禁止图像缓存。
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		resp.setContentType("image/jpeg");
		// 将图像输出到Servlet输出流中。
		ServletOutputStream sos = resp.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();
	}

}
