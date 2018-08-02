package org.test.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.test.dto.ClassDTO;
import org.test.dto.SubDTO;
import org.test.dto.UserDTO;
import org.test.dto.DefenseDTO;
import org.test.service.ClassService;
import org.test.service.DefenseService;
import org.test.service.SubService;
import org.test.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 答辩状态： 未答辩 正在答辩  完成答辩
 * Created by apple on 2017/11/16.
 */
@Controller
public class OrlDefenceCtrl {
    @Autowired
    private UserService userService;
    @Autowired
    private SubService mSubService;

    @Autowired
    private SubService subService;

    @Autowired
    private DefenseService defenseService;

    @RequestMapping("/setDefense.action")
    public ModelAndView reqSetDefensePage() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("students", userService.getAllStudents());
        model.put("subjects", subService.getSubjects());
        return new ModelAndView("/admin/oral/setDefense", model);
    }

    @RequestMapping("/defenseAdd.do")
    public ModelAndView defenseAdd(
            @RequestParam(value = "defenseSubject") Integer defenseSubject,
            @RequestParam(value = "defenseStudent") Integer defenseStudent,
            @RequestParam(value = "defenseTime") String defenseDate,
            @RequestParam(value = "defenseLocation") String location) {
        DefenseDTO defense = new DefenseDTO();
        defense.setSubjectId(defenseSubject);
        defense.setStudentId(defenseStudent);
        defense.setDefenseDate(defenseDate);
        defense.setLocation(location);

        defenseService.addDefense(defense);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("defenses", defenseService.list());
        return new ModelAndView("admin/oral/defenseList", model);
    }

    @RequestMapping("/defenseList")
    public ModelAndView defenseList() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("defenses", defenseService.list());
        return new ModelAndView("admin/oral/defenseList", model);
    }

    /**
     * 输入评分的操作
     *t_department
     * @param id
     * @param score
     */
    @RequestMapping(value = "/inputDefenseScore.do", method = RequestMethod.POST)
    @ResponseBody
    public void inputDefenseScore(
            @RequestParam(value = "id") Integer id,
            @RequestParam(value = "score") Integer score) {
        DefenseDTO defense = new DefenseDTO();
        defense.setId(id);
        defense.setScore(score);

        defenseService.inputDefenseScore(defense);
        //Map<String, Object> model = new HashMap<String, Object>();
        //model.put("defenses", defenseService.list());
        //return new ModelAndView("admin/oral/defenseList", model);
    }

    
}
