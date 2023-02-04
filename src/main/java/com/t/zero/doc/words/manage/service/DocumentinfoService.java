package com.t.zero.doc.words.manage.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.t.zero.basic.common.base.page.Page;
import com.t.zero.doc.words.dao.auto.DocumentinfoMapper;
import com.t.zero.doc.words.dao.auto.WordsinfoMapper;
import com.t.zero.doc.words.dao.manu.DocumentinfoFilters;
import com.t.zero.doc.words.dao.manu.ManuDocumentinfoMapper;
import com.t.zero.doc.words.model.auto.Documentinfo;
import com.t.zero.doc.words.model.auto.Wordsinfo;
import com.t.zero.doc.words.model.auto.WordsinfoExample;

@SessionScope
@Service
public class DocumentinfoService {

	@Autowired
	private ManuDocumentinfoMapper manuDocumentinfoMapper;
	@Autowired
	private DocumentinfoMapper documentinfoMapper;

	@Autowired
	private WordsinfoMapper wordsinfoMapper;

	public Page<Documentinfo> list(DocumentinfoFilters i, int userId, boolean selectAll) {
		Page<Documentinfo> page = Page.build(i.getCurrentPage(), i.getPageSize());
		if (!selectAll) {
			i.setUserid(userId);
		}
		page.setList(manuDocumentinfoMapper.selectListWithPageByFilter(i, page.getOffset(), page.getPageSize()));
		page.setTotalCount(manuDocumentinfoMapper.selectCountWithPageByFilter(i));
		return page;
	}

	public Documentinfo addDocumentInfo(HttpServletResponse response, Documentinfo documentInfo) {
		documentinfoMapper.insert(documentInfo);
		return documentInfo;
	}

	public Wordsinfo addWordsInfo(HttpServletResponse response, Wordsinfo wordsinfo) {
		var e = new WordsinfoExample();
		e.createCriteria().andDocidEqualTo(wordsinfo.getDocid()).andInitpageEqualTo(wordsinfo.getInitpage())
				.andPagenumEqualTo(wordsinfo.getPagenum()).andTextcontentEqualTo(wordsinfo.getTextcontent());
		var r = wordsinfoMapper.selectByExample(e);
		if (CollectionUtils.isNotEmpty(r)) {
			return r.get(0);
		}
		wordsinfo.setCreatetime(LocalDateTime.now());
		wordsinfo.setUpdatetime(LocalDateTime.now());
		wordsinfoMapper.insert(wordsinfo);
		return wordsinfo;
	}

	public List<Wordsinfo> listWords(String docid) {
		var e = new WordsinfoExample();
		e.createCriteria().andDocidEqualTo(docid);
		e.setOrderByClause("createTime desc");
		var r = wordsinfoMapper.selectByExample(e);
		return r;
	}

	public Object deleteWords(HttpServletResponse response, Wordsinfo convertValue) {
		wordsinfoMapper.deleteByPrimaryKey(convertValue.getWordsid());
		return convertValue;
	}

	public Object deleteDocument(int docid) {
		var e = new WordsinfoExample();
		e.createCriteria().andDocidEqualTo(String.valueOf(docid));
		wordsinfoMapper.deleteByExample(e);
		var t = documentinfoMapper.selectByPrimaryKey(docid);
		documentinfoMapper.deleteByPrimaryKey(docid);
		return t;
	}

}
