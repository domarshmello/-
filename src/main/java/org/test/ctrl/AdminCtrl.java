package org.test.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.test.dto.SubDTO;
import org.test.dto.UserDTO;
import org.test.service.SubService;
import org.test.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * admin Controller
 * Created by apple on 2017/11/16.
 */
@Controller
public class AdminCtrl {

    @Autowired
    private UserService mUserService;
    @Autowired
    private SubService mSubService;

    @RequestMapping("/")
    public String reqAdminPage() {
        return "/admin/index";
    }

    @RequestMapping("/studentAddView.do")
    public String reqAddStuPage() {
        return "/admin/student/studentAdd";
    }

    @RequestMapping("/studentAdd.do")
    public ModelAndView studentAdd(@RequestParam(value = "photo") MultipartFile photo,
                                   @RequestParam(value = "student_no") String studentNo,
                                   @RequestParam(value = "username") String username,
                                   @RequestParam(value = "departmentSelect") String department,
                                   @RequestParam(value = "majorSelect") String major,
                                   @RequestParam(value = "password") String password,
                                   HttpServletRequest request) {

        UserDTO student = new UserDTO();
        student.setStudentNo(studentNo);
        student.setUsername(username);
        student.setDepartment(department);
        student.setMajor(major);
        student.setPassword(new BCryptPasswordEncoder().encode(password));

        ServletContext application = request.getServletContext();
//        String realPath = application.getRealPath("/photo");
        int index = photo.getOriginalFilename().lastIndexOf(".");
        String suffix = photo.getOriginalFilename().substring(index + 1);
        String fileName = "/Users/apple/Desktop/photo" + File.separator + studentNo + "." + suffix;

        // 存文件到photo中
        try {
            photo.transferTo(new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        student.setPhotoPath(suffix);

        boolean ok = mUserService.addStudent(student);
        Map<String, Object> model = new HashMap<String, Object>();
        if (ok) {
            List<UserDTO> students = mUserService.getAllStudents();
            model.put("students", students);
            return new ModelAndView("admin/student/studentList", model);
        } else {
            model.put("info", "添加失败");
            return new ModelAndView("admin/student/studentAdd", model);
        }
    }

    /**
     * 查看学生列表
     */
    @RequestMapping("/queryStudent.do")
    public ModelAndView reqQueryPage() {
        Map<String, Object> model = new HashMap<String, Object>();
        List<UserDTO> students = mUserService.getAllStudents();
        model.put("students", students);
        return new ModelAndView("/admin/student/studentList", model);
    }

    /*
     * 更新功能
     */
    @RequestMapping("/studentUpdate.do")
    public ModelAndView updateStudentView(UserDTO userDTO) {
        boolean ok = mUserService.updateStudent(userDTO);
        Map<String, Object> model = new HashMap<String, Object>();
        List<UserDTO> students = mUserService.getAllStudents();
        model.put("students", students);
        return new ModelAndView("admin/student/studentList", model);
    }

    /*
     * 更新界面
	 */
    @RequestMapping("/studentUpdateView.do")
    public ModelAndView updateViewPage(String userId) {
        UserDTO student = mUserService.QueryById(userId);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("student", student);
        return new ModelAndView("admin/student/studentUpdate", model);
    }

    /**
     * 删除
     */
    @RequestMapping("/studentDelete.do")
    public ModelAndView delete(String userId) {

        boolean ok = mUserService.delete(userId);

        Map<String, Object> model = new HashMap<String, Object>();
        List<UserDTO> students = mUserService.getAllStudents();
        model.put("students", students);
        return new ModelAndView("/admin/student/studentList", model);
    }

    /**
     * 显示照片
     */
    @RequestMapping("/studentPhoto.do")
    public void studentPhoto(String id, String photoPath, HttpServletRequest request, HttpServletResponse response) {
        // 找到文件
        ServletContext application = request.getServletContext();
        // String realPath = application.getRealPath("/Users/apple/Desktop/photo");
        String fileName = "/Users/apple/Desktop/photo" + File.separator + id + "." + photoPath;
        File file = new File(fileName);
        if (file.exists()) {
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null)
                    try {
                        bis.close();
                    } catch (Exception e) {
                    }
                if (fis != null)
                    try {
                        fis.close();
                    } catch (Exception e) {
                    }
            }
        }
    }

    /**
     * 查看学生列表
     */
    @RequestMapping("/studentList.do")
    public ModelAndView studentList() {
        Map<String, Object> model = new HashMap<String, Object>();
        List<UserDTO> students = mUserService.getAllStudents();
        model.put("students", students);
        return new ModelAndView("admin/student/studentList", model);
    }


    @RequestMapping("/teacherList.do")
    public ModelAndView teacherList() {
        Map<String, Object> model = new HashMap<String, Object>();
        List<UserDTO> teachers = mUserService.getAllTeachers();
        model.put("teachers", teachers);
        return new ModelAndView("admin/teacher/teacherList", model);
    }

    @RequestMapping("/teacherAddView.do")
    public String reqAddTECPage() {
        return "/admin/teacher/teacherAdd";
    }


    /**
     * 查看teacher列表
     */
    @RequestMapping("/queryTeacher.do")
    public ModelAndView reqQueryTeachPage() {
        Map<String, Object> model = new HashMap<String, Object>();
        List<UserDTO> teachers = mUserService.getAllTeachers();
        model.put("teachers", teachers);
        return new ModelAndView("/admin/teacher/teacherList", model);
    }


    /*
    * 更新界面
    */
    @RequestMapping("/teacherUpdateView.do")
    public ModelAndView updateViewPageTeacher(String userId) {
        UserDTO teacher = mUserService.QueryById(userId);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("teacher", teacher);
        return new ModelAndView("admin/teacher/teacherUpdate", model);
    }
    /*
     * 更新功能
     */
    @RequestMapping("/teacherUpdate.do")
    public ModelAndView updateTeacherView(UserDTO userDTO) {
        boolean ok = mUserService.updateStudent(userDTO);
        Map<String, Object> model = new HashMap<String, Object>();
        List<UserDTO> teachers = mUserService.getAllTeachers();
        model.put("teachers", teachers);
        return new ModelAndView("/admin/teacher/teacherList", model);
    }




    /**
     * 删除教师
     */
    @RequestMapping("/teacherDelete.do")
    public ModelAndView deleteTeacher(String userId) {

        boolean ok = mUserService.delete(userId);
        Map<String, Object> model = new HashMap<String, Object>();
        List<UserDTO> teachers = mUserService.getAllStudents();
        model.put("teachers", teachers);
        return new ModelAndView("/admin/teacher/teacherList", model);
    }

    @RequestMapping("/teacherAdd.do")
    public ModelAndView teacherAdd(@RequestParam(value = "photo") MultipartFile photo,
                                   @RequestParam(value = "username") String username,
                                   @RequestParam(value = "departmentSelect") String department,
                                   @RequestParam(value = "majorSelect") String major,
                                   @RequestParam(value = "password") String password,
                                   HttpServletRequest request) {
        UserDTO teacher = new UserDTO();
        teacher.setUsername(username);
        teacher.setDepartment(department);
        teacher.setMajor(major);
        teacher.setPassword(new BCryptPasswordEncoder().encode(password));

        ServletContext application = request.getServletContext();
        String realPath = application.getRealPath("/photo/");
        int index = photo.getOriginalFilename().lastIndexOf(".");
        String suffix = photo.getOriginalFilename().substring(index + 1);
        String fileName = realPath + File.separator + username + "." + suffix;

        // 存文件到photo中
        try {
            photo.transferTo(new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        teacher.setPhotoPath(suffix);
        boolean ok = mUserService.addTeacher(teacher);
        Map<String, Object> model = new HashMap<String, Object>();
        if (ok) {
            List<UserDTO> teachers = mUserService.getAllTeachers();
            model.put("teachers", teachers);
            return new ModelAndView("admin/teacher/teacherList", model);
        } else {
            model.put("info", "添加失败");
            return new ModelAndView("admin/teacher/teacherAdd", model);
        }

    }


//    @RequestMapping(value = "/SubjectList.action")
//    public ModelAndView subjectList() {
//        Map<String, Object> model = new HashMap<String, Object>();
//        List<SubDTO> subjects = mSubService.getSubjects();
//        model.put("subjects", subjects);
//        return new ModelAndView("admin/subject/subjectList", model);
//    }
//
//    @RequestMapping(value = "/subjects")
//    @ResponseBody
//    public ResponseEntity getSubjects() {
//        return ResponseEntity.ok(mSubService.getSubjects());
//    }
//
//
//    @RequestMapping(value = "/subjectAdd.do")
//    public ModelAndView subjectAdd(@RequestParam(value = "subName") String subName,
//                                   @RequestParam(value = "subDesc") String subDesc,
//                                   HttpServletRequest request) {
//        SubDTO subject = new SubDTO();
//        subject.setSubName(subName);
//        subject.setSubDesc(subDesc);
//        ServletContext application = request.getServletContext();
//
//        boolean ok = mSubService.addSubject(subject);
//        Map<String, Object> model = new HashMap<String, Object>();
//        if (ok) {
//            List<SubDTO> subjects = mSubService.getSubjects();
//            model.put("subjects", subjects);
//            return new ModelAndView("admin/subject/subjectList", model);
//        } else {
//            model.put("info", "添加失败");
//            return new ModelAndView("admin/subject/subjectAdd", model);
//        }
//
//    }
//    @RequestMapping("/subjectAddView.do")
//    public String reqAddSubPage() {
//        return "admin/subject/subjectAdd";
//
//    }
//    //    修改本质是查询
//
//    @RequestMapping(value = "/subjectUpdateView.do")
//    public String subjectUpdateView(String subId, Model model) {
//        SubDTO subject = mSubService.findById(subId);
//        model.addAttribute("subjects", subject);
//        return "admin/subject/subjectUpdate";
//    }
//    /**
//     * 更新辩题功能
//     */
//    @RequestMapping("/subjectUpdate.do")
//    public ModelAndView updateSubjectView(SubDTO subDTO) {
//        boolean ok = mSubService.updateSubject(subDTO);
//        Map<String, Object> model = new HashMap<String, Object>();
//        List<SubDTO> subjects = mSubService.getSubjects();
//        model.put("subjects", subjects);
//        return new ModelAndView("admin/subject/subjectList", model);
//    }
//    /**
//     * 删除
//     */
//    @RequestMapping("/subjectDelete.do")
//    public ModelAndView deleteSub(String subId) {
//
//        boolean ok = mSubService.delete(subId);
//
//        Map<String, Object> model = new HashMap<String, Object>();
//        List<SubDTO> subject = mSubService.getSubjects();
//        model.put("subjects", subject);
//        return new ModelAndView("/admin/subject/subjectList", model);
//    }
//
//
//    @RequestMapping("/mangeDefenseView.action")
//    public String ResScorePage() {
//        return "/admin/mange/mangeDefense";
//
//    }
//
//    @RequestMapping("/mangeMembersScoreView.action")
//    public String ResMembersScorePage() {
////        return "/admin/mange/mangeMembersScore";
//        return "redirect: teacherList.do";
//
//    }

}




