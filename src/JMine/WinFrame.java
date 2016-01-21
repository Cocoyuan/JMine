package JMine;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


class WinFrame extends JFrame implements MouseListener{
	private JPanel winPane;
	private JPanel textPane;
	private JPanel snsPane;
	private JPanel buttonPane;
	private JLabel msg;
	private JTextField text;
	private JButton share;
	private JButton restart;
	private int level;
	private boolean isOk;
	private JRadioButton weibo;
    private JRadioButton facebook;

	public WinFrame(String strName) {
		
		super(strName);
		setSize(350, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		level = 1;
		isOk = false;
		
		winPane = new JPanel();
		winPane.setLayout(new BoxLayout(winPane, BoxLayout.Y_AXIS));
		
		textPane = new JPanel();
		textPane.setLayout(new BoxLayout(textPane, BoxLayout.Y_AXIS));
		msg = new JLabel("share to your SNS!");
		snsPane = new JPanel();
		snsPane.setLayout(new BoxLayout(snsPane, BoxLayout.X_AXIS));
		weibo = new JRadioButton("Weibo");
	    facebook = new JRadioButton("Facebook");
	    ButtonGroup sns = new ButtonGroup();
	    sns.add(weibo);
	    sns.add(facebook);
		text = new JTextField();
		text.setText("Yeah! I won a minesweeper! Congratulate me!");
		text.setPreferredSize(new Dimension(10,20));
		//+ new JCounter().getCounterNum() +"seconds
		share = new JButton("Share");
		share.addActionListener(shareButtonListener);
		restart = new JButton("Restart");
		restart.addActionListener(restartButtonLIstener);
		restart.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				new JMine().setNewGame(12);
				//System.exit(0);
				setVisible(false);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		//msg3 = new JLabel("  Click to restart!  ");
		
		winPane.add(textPane);
		textPane.add(msg);
		textPane.add(snsPane);
		snsPane.add(weibo);
		snsPane.add(facebook);
		textPane.add(text);
		buttonPane = new JPanel();
		winPane.add(buttonPane);
		
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.X_AXIS));
		buttonPane.add(share);
		buttonPane.add(restart);
		
		
		setContentPane(winPane);
		setLocation(250,220);
		this.setVisible(true);
	}
	
	public WinFrame() {
		
		this.setVisible(false);
		this.dispose();
		
	}
	
	public int getLevel() {
		return(level);
	}
	
	public int getMineNum() {	
		return(level*12);
	}
	
	public boolean getWinOk() {
		return(isOk);
	}

	public ActionListener shareButtonListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			URL url = getClass().getResource("");
			System.out.println(url);
			Desktop desktop = Desktop.getDesktop();
			DefaultButtonModel model = (DefaultButtonModel) weibo.getModel();
			if (model.getGroup().isSelected(model)){
				try {
					desktop.browse(new URI("http://www.weibo.com/home"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//weibo备选

			else{
				try {
					desktop.browse(new URI("https://www.facebook.com/"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			new JMine().setNewGame(12);
			setVisible(false);
			System.out.print("share successed!");
		}
	};
	
	public ActionListener restartButtonLIstener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//System.exit(0);
			
			new JMine().setNewGame(12);
			//this.setVisible(false);
			//this.dispose();
			//WinFrame win = new WinFrame("Win");
			//win.dispose();
		}
	};
	

	//发布facebook动态
	public void facebookSnsSend(String access_token) throws Exception{
	        Map<String, String> header = WinFrame.getHeader();
	        String post = WinFrame.facebookAccess();
	        //String returMailJson = WinFrame.postMethodRequestWithOutFile(post, WinFrame.getfbParamsInfo(access_token,text.toString()), header);
		//Map<String, String> header =App.getHeader();
	        //String sinaweibo=App.facebookMiceoBo();
	        //String returnMailJson=App.postMethodRequestWithOutFile(sinaweibo,App.getfbParamsInfo(access_token,topic.getTitle(),return_url), header);
	        //JForumExecutionContext.setRedirect(return_url);
	    }

	//头部信息
	public static Map<String, String> getHeader() {
	        Map<String, String> header = new HashMap<String, String>();
	        header.put("Accept-Language", "zh-CN,zh;q=0.8");
	        header.put("User-Agent", "test facebook api");
	        header.put("Accept-Charset", "utf-8;q=0.7,*;q=0.3");
	        return header;
	    }
	//访问facebook链接
	public static String facebookAccess(){
	        StringBuffer sb = new StringBuffer();
	        sb.append("https://www.facebook.com/");
	        //sb.append("https://graph.facebook.com/me/feed");
	        return sb.toString();
	    }
	//post提交数据
	public static Map<String, String> getfbParamsInfo(String access_token) throws UnsupportedEncodingException {
	        Map<String, String> params = new HashMap<String, String>();
	        params.put("message", "everyhguonwqeqwewe");
	        params.put("access_token", access_token);
	        params.put("privacy","ALL_FRIENDS");
	        return params;
	    }
	
	public void mousePressed(MouseEvent e) {
		//System.out.println("Coco Press");
		//this.setVisible(false);

	}
	

	public void mouseReleased(MouseEvent e) {
		//System.out.println("Coco Release");
		this.setVisible(false);
	}
	public void mouseExited(MouseEvent e) {
		//System.out.println("Coco Exited");

	}
	public void mouseEntered(MouseEvent e) {
		//System.out.println("Coco Entered");

	}

	public static void main(String[] args) {
		WinFrame win = new WinFrame("Win");
		win.show();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}
}
