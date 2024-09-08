package com.mpt.journal.controller;

import com.mpt.journal.model.JobModel;
import com.mpt.journal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;


@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public String getAllJobs(Model model) {
        model.addAttribute("jobs", jobService.findAllJob()); // просто выгрузка студентов на экран
        return "jobList";
    }

    @PostMapping("/jobs/add")
    public String addJob(@RequestParam String name) {
        JobModel newJob = new JobModel(0, name); // тут мы получаем данные с главных полей, id задается автоматически из нашего репозитория
        jobService.addJob(newJob); // добавление студента в оперативную память(после перезапуска проекта, все данные стираются)
        return "redirect:/jobs"; // Здесь мы с вами используем redirect на наш GetMapping, чтобы не создавать много однотипных страниц, считай просто презагружаем страницу с новыми данными
    }

    @PostMapping("/jobs/update")
    public String updateJob(@RequestParam int id,
                                @RequestParam String name) {
        JobModel updatedJob = new JobModel(id, name); // Получаем новые данные из полей для обновления
        jobService.updateJob(updatedJob); // Ссылаемся на наш сервис для обновления по id
        return "redirect:/jobs"; // Здесь мы с вами используем redirect на наш GetMapping, чтобы не создавать много однотипных страниц, считай просто презагружаем страницу с новыми данными
    }

    @PostMapping("/jobs/delete")
    public String deleteJobs(@RequestParam int id) {
        jobService.deleteJob(id); // Ссылаемся на наш сервис для удаления по id
        return "redirect:/jobs"; // Здесь мы с вами используем redirect на наш GetMapping, чтобы не создавать много однотипных страниц, считай просто презагружаем страницу с новыми данными
    }
}
