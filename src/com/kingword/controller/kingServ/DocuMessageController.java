package com.kingword.controller.kingServ;

 import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource; 


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kingword.common.filehandle.FileHandleFactory;
import com.kingword.common.filehandle.FileUpload;
import com.kingword.common.filehandle.FileUploadHand;
import com.kingword.common.filehandle.FileUploadHandWord;
import com.kingword.entity.kingword.DocuKWPageCount;
import com.kingword.entity.kingword.DocuMessage;
import com.kingword.entity.kingword.KingWord;
import com.kingword.entity.kingword.RelationDocuWord;
import com.kingword.entitycommon.DocuForm;
import com.kingword.entitycommon.DocuKWPageCountForm;
import com.kingword.entitycommon.DocuMessForm;
import com.kingword.entitycommon.DocuPageKWCount;
import com.kingword.entitycommon.DocuWordForm;
import com.kingword.entitycommon.RelDocuKingWordForm;






@Controller  
@RequestMapping(value="/KW")
public class DocuMessageController {
	
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(DocuMessageController.class); 
	//文档信息表
	@Resource(name="docuMessServImpl")
    private DocuMessServ docuMessServ;
	//关键字库信息表
	@Resource(name="kingWordServImpl")
    private KingWordServ kingWordServ;
	//关键字在文档中的统计信息
	@Resource(name="relDocuWordServImpl")
    private RelDocuWordServ relationDocuWordServ;
	//关键字在文档中每页出现的次数
	@Resource(name="docuKWPCServImpl")
    private DocuKWPCServ docuKWPCServ;
	
	/*
     * ���ĵ���Ϣ������Ӽ�¼*/
    @RequestMapping(value = "/docu/getReady") 
    @ResponseBody 
    public  Map<String, String> getReady(HttpSession session ) throws UnsupportedEncodingException {
    	Map<String, String> list=new HashMap<String,String>();
    	String userName = (String) session.getAttribute("currentUserCode");
    	if(userName==null){
    		list.put("false", "请登录");
    		return list;  
    	}
    	System.out.println(userName);
    	System.out.println(userName+"----------------------------------------------");
    	list.put("true", userName);
	    return list;  
    } 
    /*
     * ���ĵ���Ϣ������Ӽ�¼*/
    @RequestMapping(value = "/docu/add",method=RequestMethod.POST, headers = {"content-type=application/json","content-type=application/xml"}) 
    @ResponseBody 
    public  List<DocuMessage> add(@RequestBody  DocuForm docuForm, HttpSession session ) throws UnsupportedEncodingException {
        List<DocuMessage> list = new LinkedList<DocuMessage>();
    	String userCode = (String)session.getAttribute("currentUserCode");
    	System.out.println(userCode);
    	System.out.println("dsfghgfd");
        System.out.println(docuForm.getWordName());
        DocuMessage docuMessage=new DocuMessage();
        docuMessage.setWordName(docuForm.getWordName());
        docuMessage.setSubmitor(userCode);
        docuMessage.setWriter(docuForm.getWriter());
        docuMessage.setSubmitDate(new Timestamp(new Date().getTime()) );
        DocuMessage docu=docuMessServ.saveDocuMessage(docuMessage);
    	list.add(docu);
    	System.out.println(userCode);

		return list;  
    } 
    /*
     * ϵͳ��������Զ�����
     * */
    @RequestMapping("/docu/uploadfile")
    @ResponseBody
    public List<DocuWordForm>  fileUpload(@RequestParam("docuId") String docuId,Model model, HttpServletRequest request,RedirectAttributes attr) {
     	Map<String, String> mapName=new HashMap<String, String>();
    	Enumeration<String> keys = request.getParameterNames();
	   	while(keys.hasMoreElements()) {
	   	    String k = keys.nextElement();
	   	    System.out.println(k + " = " + request.getParameter(k) );
	   	} 
     	BigDecimal docuWordId= new BigDecimal(docuId); 
     	DocuMessage docuMessage=docuMessServ.findById(docuWordId);
     	
     		try {
				mapName=new FileUpload().doPost( request,  kingWordServ, 
												 relationDocuWordServ,
												 docuMessage);
			} catch (ServletException e) {
  				e.printStackTrace();
			} catch (IOException e) {
 				e.printStackTrace();
			}
 		 
     	String relativePath=mapName.get("relative_path");
     	String newFileName=mapName.get("newfileName");
     	attr.addAttribute("docPath", relativePath+newFileName);
     	List<DocuWordForm> listDForm=new  ArrayList<DocuWordForm>();
     	DocuWordForm docuWordForm=null;
     	for (RelationDocuWord docukW : relationDocuWordServ.finddocumass(docuMessage)) {
     		docuWordForm=new DocuWordForm();
     		docuWordForm.setDocuName(docukW.getKingWordName());
     		docuWordForm.setWordcount(docukW.getKingWordCount());
         	listDForm.add(docuWordForm);
 		}     	
 		return listDForm;
     }
    
    
  

    @RequestMapping(value = "/docu/getKingWords") 
    @ResponseBody 
    public  List<KingWord> getKingWords(HttpServletRequest request, ModelMap model )  { 
    	
		return kingWordServ.findAllKingWord();
   } 
    @RequestMapping(value = "/docu/getKingWordscount") 
    @ResponseBody 
    public  int getKingWordscount(HttpServletRequest request, ModelMap model )  { 
    	
		return kingWordServ.findAllKingWord().size();
   } 
    @RequestMapping(value = "/docu/getKingWordEdit") 
    @ResponseBody 
    public  KingWord getKingWordEdit(@RequestParam(value = "kingWordId", required = false) int kingWordId, HttpServletRequest request, ModelMap model )  { 
    	
		return kingWordServ.findAllKingWordId(new BigDecimal(kingWordId)); 
   } 
    
    
    @RequestMapping(value = "/docu/getDocuMessages") 
    @ResponseBody 
    public  List<DocuMessForm> getDocuMessage(HttpServletRequest request, HttpSession session,ModelMap model )  { 
    	List<DocuMessForm> listrkd=new  ArrayList<DocuMessForm>();
    	String userCode = (String)session.getAttribute("currentUserCode");
    	System.out.println(userCode);
    	System.out.println("--------------------------------------");
    	DocuMessForm docuMessForm=null; 
    	for ( DocuMessage kingWord : docuMessServ.findAllDocuMessages(userCode)) {
    		docuMessForm=new DocuMessForm();
    		docuMessForm.setDocuId 			(kingWord.getDocuId()); 
    		docuMessForm.setWordName        (kingWord.getWordName()); 
    		docuMessForm.setSubjectTypeId   (kingWord.getSubjectTypeId()); 
    		docuMessForm.setType            (kingWord.getType()); 
    		docuMessForm.setWriter          (kingWord.getWriter() );
    		docuMessForm.setRealFileName    (kingWord.getRealFileName() );
    		docuMessForm.setServFilePath    (kingWord.getServFilePath()); 
    		docuMessForm.setSubmitDate      (kingWord.getSubmitDate() );
    		docuMessForm.setSubmitor        (kingWord.getSubmitor() );
    		docuMessForm.setSubmitorPhone   (kingWord.getSubmitorPhone() );
    		docuMessForm.setWriterPhone     (kingWord.getWriterPhone()); 
    		docuMessForm.setRemark          (kingWord.getRemark() );
    		listrkd.add(docuMessForm);
    	}
    	System.out.println(userCode);
    	System.out.println("--------------------------------------");
		return listrkd;
   }  
    
    /**
     * ����ĵ�ID��ȡ�ĵ���Ϣ
     * 
     * */
    @RequestMapping(value = "/docu/getDocuMessdetail") 
    @ResponseBody 
    public  DocuMessForm getDocuMessdetail(@RequestParam(value = "docuId", required = false) int docuId, 
    										HttpServletRequest request, ModelMap model )  { 
    	DocuMessage kingWord=docuMessServ.findById(new BigDecimal(docuId));
    	DocuMessForm docuMessForm=new DocuMessForm();
    	docuMessForm.setDocuId 			(kingWord.getDocuId()); 
		docuMessForm.setWordName        (kingWord.getWordName()); 
		docuMessForm.setSubjectTypeId   (kingWord.getSubjectTypeId()); 
		docuMessForm.setType            (kingWord.getType()); 
		docuMessForm.setWriter          (kingWord.getWriter() );
		docuMessForm.setRealFileName    (kingWord.getRealFileName() );
		docuMessForm.setServFilePath    (kingWord.getServFilePath()); 
		docuMessForm.setSubmitDate      (kingWord.getSubmitDate() );
		docuMessForm.setSubmitor        (kingWord.getSubmitor() );
		docuMessForm.setSubmitorPhone   (kingWord.getSubmitorPhone() );
		docuMessForm.setWriterPhone     (kingWord.getWriterPhone()); 
		docuMessForm.setRemark          (kingWord.getRemark() );
		return docuMessForm;  
   }
    
    
    /**
     * ����ĵ�ID��ȡ�ؼ������ĵ��е�ʹ�����
     * 
     * */
    @RequestMapping(value = "/docu/getdocuWordetail") 
    @ResponseBody 
    public  List<RelDocuKingWordForm> getdocuWordetail(@RequestParam(value = "docuId", required = false) int docuId,
    													HttpServletRequest request,
    													HttpSession session,ModelMap model )  { 
    	BigDecimal docuWordId= new BigDecimal(docuId);
    	List<RelDocuKingWordForm> listDForm=new  ArrayList<RelDocuKingWordForm>();
    	RelDocuKingWordForm dForm=null;
    	DocuMessage dMessage=docuMessServ.findById(docuWordId);
       	for (RelationDocuWord docukW : relationDocuWordServ.finddocumass(dMessage)) {
       		dForm=new RelDocuKingWordForm();
       		dForm.setWordName (dMessage.getWordName()) ;
       		dForm.setRealFileName     (dMessage.getRealFileName     ()) ;
       		dForm.setRelDocuKingWord (docukW.getRelDocuKingWord     ()) ;
       		dForm.setKingWordName      (docukW.getKingWordName()) ;
       		dForm.setKingWordCount   (docukW.getKingWordCount   ()) ;
       		dForm.setCreateDate  (docukW.getCreateDate()) ;
       		listDForm.add(dForm);
 		}
       	System.out.println(listDForm.size());
		return listDForm;  
   }
   /**
    * ����ĵ�ID��ȡ�ؼ������ĵ��е�ʹ�����
    * 
    * */
   @RequestMapping(value = "/docu/getdocuWordetailpage") 
   @ResponseBody 
   public  List<DocuKWPageCountForm> getdocuWordetailpage(@RequestParam(value = "docuId", required = false) long relDocuKingWord, HttpServletRequest request, ModelMap model )  { 
   	List<DocuKWPageCountForm> listDForm=new  ArrayList<DocuKWPageCountForm>();
   	DocuKWPageCountForm dForm=null;
   	System.out.println(relDocuKingWord);
      	for (DocuKWPageCount docukW : docuKWPCServ.findById(relDocuKingWord)) {
      		dForm=new DocuKWPageCountForm();
      		dForm.setDocuKWPageId(docukW.getDocuKWPageId().longValue());
      		dForm.setKingWordName(docukW.getKingWordName());
      		dForm.setDocuFileName(docukW.getDocuFileName());
      		dForm.setPageCode(docukW.getPageCode());
      		dForm.setPageKWCount(docukW.getPageKWCount());
      		dForm.setState(docukW.getState());
      		dForm.setRemark(docukW.getRemark());
      		listDForm.add(dForm);
		}
      	System.out.println(listDForm.size());
		return listDForm;  
  }
   
   @RequestMapping("/docu/uploadfilehand")
   @ResponseBody
   public DocuWordForm  fileUploadhand(@RequestParam("docuId") String docuId,Model model, HttpServletRequest request,RedirectAttributes attr) {
	   	Map<String, String> mapName=new HashMap<String, String>();
	   	/*
	   	//打印请求参数
	   	Enumeration<String> keys = request.getParameterNames();
	   	while(keys.hasMoreElements()) {
	   	    String k = keys.nextElement();
	   	    System.out.println(k + " = " + request.getParameter(k) );
	   	}
	   	*/
	   	
 	   	try {	
	   		mapName=new FileUploadHandWord().dofilehand(request);
		} catch (ServletException | IOException e) {
				e.printStackTrace();
		}
 	   	BigDecimal docuWordId= new BigDecimal(docuId); 
	   	String relativePath=mapName.get("relativePath");
	   	String newFileName=mapName.get("newfileName");
	   	String newpath=relativePath+newFileName;
	   	attr.addAttribute("docPath", newpath);  
	   	DocuMessage dMessage=docuMessServ.findById(docuWordId);
 
	   	dMessage.setType(mapName.get("nameType"));
	   	dMessage.setRemark(mapName.get("fileName"));
	   	dMessage.setRealFileName(mapName.get("fileName"));
	   	dMessage.setServFilePath(newpath);
	   	docuMessServ.saveDocuMessage(dMessage);
	   	DocuWordForm docuWordFormtemp=new DocuWordForm();
	   	docuWordFormtemp.setWordName(newpath);
	   	docuWordFormtemp.setUpLoader("qwew");
		return docuWordFormtemp;
    }
   @RequestMapping("/docu/getdocubyid")
   @ResponseBody
   public DocuWordForm  getdocubyid(@RequestParam(value = "docuId", required = true) int docuId,Model model, HttpServletRequest request,RedirectAttributes attr) {
    	BigDecimal docuWordId= new BigDecimal(docuId); 
	   	DocuWordForm docuWordFormtemp=new DocuWordForm();
	   	DocuMessage docuMess = docuMessServ.findById(docuWordId);
    	if(docuMessServ.findByIdCount(docuWordId)==0){
    		docuWordFormtemp.setDocuName("没有查到文档ID，请重新输入");
    		return docuWordFormtemp;
    	}
    	String wordName=docuMess.getWordName();
    	if(wordName==null){
    		docuWordFormtemp.setDocuName("文档ID已查到但文档名称没有录入，请修改文档信息");

    		return docuWordFormtemp;
    	}
		docuWordFormtemp.setDocuName(wordName);
		docuWordFormtemp.setWordName(docuMess.getServFilePath());
    	System.out.println(wordName);
    	return docuWordFormtemp;
    }
   @RequestMapping("/showpdf/getKWordCount")
   @ResponseBody
   public List<DocuKWPageCount>  getKWordCount(@RequestParam(value = "docuId", required = true) int docuId,
				@RequestParam(value = "docuServPath", required = true) String docuServPath,
					@RequestParam(value = "KWordname", required = true) String KWordname,
		   								Model model, HttpServletRequest request,RedirectAttributes attr) {
    	System.out.println("-----------------------------------------------------");
	    BigDecimal docuWordId= new BigDecimal(docuId); 
    	List<DocuKWPageCount> rkdList=new ArrayList<DocuKWPageCount>();
    	DocuKWPageCount rkdp=new DocuKWPageCount();
	   	Map<Integer, Integer> KWordnameCountMap=null;
	   	int kingWordCount=0;
	   	RelationDocuWord rkd=new RelationDocuWord();
	   	rkd.setKingWordName(KWordname);
	   	rkd.setCreateDate(new Timestamp(new Date().getTime()));
	   	rkd.setDocuMessage(docuMessServ.findById(new BigDecimal(docuId)));
	   	try {
	   		KWordnameCountMap = FileHandleFactory.getFileHandleOnHand(docuServPath,"123",KWordname);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	   	if(KWordnameCountMap!=null){
	   		for (Integer key : KWordnameCountMap.keySet()) {
	   		   rkdp=new DocuKWPageCount();
	   		   rkdp.setDocuId(docuWordId);
	   		   rkdp.setKingWordName(KWordname);
	   		   rkdp.setDocuFileName(docuServPath);
	   		   rkdp.setPageCode(new Long(key));
	   		   rkdp.setPageKWCount(new Long(KWordnameCountMap.get(key)));
	   		   docuKWPCServ.save(rkdp);
	   		   kingWordCount=kingWordCount+KWordnameCountMap.get(key);
	   		   rkdList.add(rkdp);
	   		  }
	   	}
	   	rkd.setKingWordCount(new Long(kingWordCount));
		relationDocuWordServ.save(rkd);
		rkdp=new DocuKWPageCount();
		rkdp.setRemark("countAll");
		rkdp.setKingWordName(KWordname);
		rkdp.setPageKWCount(new Long(kingWordCount));
    	return rkdList;
    }
   @RequestMapping("/showpdf/getKWordCountnostatic")
   @ResponseBody
   public List<DocuKWPageCount>  getKWordCountnostatic(@RequestParam(value = "docuId", required = true) int docuId,
				@RequestParam(value = "docuServPath", required = true) String docuServPath,
					@RequestParam(value = "KWordname", required = true) String KWordname,
		   								Model model, HttpServletRequest request,RedirectAttributes attr) {
    	List<DocuKWPageCount> rkdList=new ArrayList<DocuKWPageCount>();
    	   	return rkdList;
    }
 
   @RequestMapping("/showpdf/getKWname1")
    @ResponseBody
    public DocuWordForm  getKWname(Model model, HttpServletRequest request,RedirectAttributes attr) {
 	   
 		return null;
     }
    @RequestMapping(value = "/docu/getonhandKingword") 
    @ResponseBody 
    public  List<DocuPageKWCount> getonhandKingword(@RequestParam(value = "docuId", required = true) int docuId,
    											 @RequestParam(value = "onhandkingword", required = true) String onhandkingword, 
    											 @RequestParam(value = "filenamepathonhand", required = true) String filenamepathonhand,
    											 HttpServletRequest request, ModelMap model )  { 
    	List<DocuPageKWCount> docuPageKWCount=new  ArrayList<DocuPageKWCount>();
    	DocuPageKWCount docuPageCount=new DocuPageKWCount();
    	DocuMessage domessageonhand = docuMessServ.findById(new BigDecimal(docuId));
    	Map<Integer, Integer> map = null;
    	DocuKWPageCount docuKWPageCount=null;
    	int pageId = 0;
    	int  pageKWCount= 0;
    	int  KWCount= 0;
    	filenamepathonhand=domessageonhand.getServFilePath();
    	try {
    		map=FileHandleFactory.getFileHandleOnHand(filenamepathonhand, domessageonhand.getType(), onhandkingword);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	if(map.size()!=0){
	    	RelationDocuWord rkd=relationDocuWordServ.findbByKWNameAndDocuId(new BigDecimal(docuId),onhandkingword);
	    	if(rkd==null){
	    		rkd=new RelationDocuWord();
		    	rkd.setKingWordName(onhandkingword);
		       	rkd.setDocuMessage(domessageonhand);
		       	rkd.setCreateDate(new Timestamp(new Date().getTime()));
		       	rkd=relationDocuWordServ.save(rkd);
		    }
	    	for (Map.Entry<Integer, Integer> entry : map.entrySet()) {  
	    		docuPageCount=new DocuPageKWCount();
	    	    pageId=entry.getKey();
	    	    pageKWCount= entry.getValue();
	    	    docuPageCount.setDocuId(docuId);
	    	    docuPageCount.setFilenamepathonhand(filenamepathonhand);
	    	    docuPageCount.setOnhandkingword(onhandkingword);
	    	    docuPageCount.setPageId(pageId);
	    	    docuPageCount.setPageKWCount(pageKWCount);    	    
	    	    docuPageKWCount.add(docuPageCount);
	    	}  
	    	for (DocuPageKWCount docuPage : docuPageKWCount) {
	    		docuKWPageCount = docuKWPCServ.findByrkdRelDWAndPageCode(rkd.getRelDocuKingWord(),(long) docuPage.getPageId());
	    		if(docuKWPageCount==null){
	    			docuKWPageCount=new DocuKWPageCount();
	    			docuKWPageCount.setDocuId(domessageonhand.getDocuId());
		    		docuKWPageCount.setRelationDocuWord(rkd);
		    		docuKWPageCount.setDocuName(domessageonhand.getWordName());
		    		docuKWPageCount.setKingWordName(rkd.getKingWordName());
		    		docuKWPageCount.setDocuFileName(domessageonhand.getRealFileName());
		    		docuKWPageCount.setPageCode((long) docuPage.getPageId());
	    		}
	    		docuKWPageCount.setPageKWCount((long) docuPage.getPageKWCount());
	    		KWCount=KWCount+docuPage.getPageKWCount();
	    		docuKWPCServ.save(docuKWPageCount);
			}
	    	rkd.setKingWordCount((long) KWCount);
    		relationDocuWordServ.save(rkd);

    	}
		return docuPageKWCount;  
   }
  
}
