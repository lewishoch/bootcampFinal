package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.stream.FileImageInputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="pic")
public class PicController {
	private final String UPLOAD_DIR = "d:/upload/";
	@RequestMapping("get")
	public void getPic(OutputStream os, String imgName) throws FileNotFoundException, IOException{
		String imgPath = UPLOAD_DIR + imgName;
		FileImageInputStream fiis = new FileImageInputStream(new File(imgPath));
		
		byte[] buff = new byte[1024];
		while(fiis.read(buff)!=-1){
			os.write(buff);
			
		}
		
	}
}
