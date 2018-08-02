package org.test.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.test.dto.SubDTO;
import org.test.service.SubService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * subject__controller
 * Created by apple on 2017/11/16.
 */
@Controller
public class SubCtrl {
    @Autowired
    private SubService mSubService;

    @RequestMapping(value = "/SubjectList.action")
    public ModelAndView subjectList() {
        Map<String, Object> model = new HashMap<String, Object>();
        List<SubDTO> subjects = mSubService.getSubjects();
        model.put("subjects", subjects);
        return new ModelAndView("admin/subject/subjectList", model);
    }

    @RequestMapping(value = "/subjects")
    @ResponseBody
    public ResponseEntity getSubjects() {
        return ResponseEntity.ok(mSubService.getSubjects());
    }


    @RequestMapping(value = "/subjectAdd.do")
    public ModelAndView subjectAdd(@RequestParam(value = "subName") String subName,
                                   @RequestParam(value = "subDesc") String subDesc,
                                   HttpServletRequest request) {
        SubDTO subject = new SubDTO();
        subject.setSubName(subName);
        subject.setSubDesc(subDesc);
        ServletContext application = request.getServletContext();

        boolean ok = mSubService.addSubject(subject);
        Map<String, Object> model = new HashMap<String, Object>();
        if (ok) {
            List<SubDTO> subjects = mSubService.getSubjects();
            model.put("subjects", subjects);
            return new ModelAndView("admin/subject/subjectList", model);
        } else {
            model.put("info", "添加失败");
            return new ModelAndView("admin/subject/subjectAdd", model);
        }

    }
    @RequestMapping("/subjectAddView.do")
    public String reqAddSubPage() {
        return "admin/subject/subjectAdd";

    }
    //    修改本质是查询

    @RequestMapping(value = "/subjectUpdateView.do")
    public String subjectUpdateView(String subId, Model model) {
        SubDTO subject = mSubService.findById(subId);
        model.addAttribute("subjects", subject);
        return "admin/subject/subjectUpdate";
    }
    /**
     * 更新辩题功能
     */
    @RequestMapping("/subjectUpdate.do")
    public ModelAndView updateSubjectView(SubDTO subDTO) {
        boolean ok = mSubService.updateSubject(subDTO);
        Map<String, Object> model = new HashMap<String, Object>();
        List<SubDTO> subjects = mSubService.getSubjects();
        model.put("subjects", subjects);
        return new ModelAndView("admin/subject/subjectList", model);
    }
    /**
     * 删除
     */
    @RequestMapping("/subjectDelete.do")
    public ModelAndView deleteSub(String subId) {

        boolean ok = mSubService.delete(subId);

        Map<String, Object> model = new HashMap<String, Object>();
        List<SubDTO> subject = mSubService.getSubjects();
        model.put("subjects", subject);
        return new ModelAndView("/admin/subject/subjectList", model);
    }


    @RequestMapping("/mangeDefenseView.action")
    public String ResScorePage() {
        return "/admin/mange/mangeDefense";

    }

    @RequestMapping("/mangeMembersScoreView.action")
    public String ResMembersScorePage() {
//        return "/admin/mange/mangeMembersScore";
        return "redirect: teacherList.do";

    }



}
