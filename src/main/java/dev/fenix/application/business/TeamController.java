package dev.fenix.application.business;
 
import dev.fenix.application.business.module.Team;
import dev.fenix.application.business.repository.TeamRepository;
import dev.fenix.application.template.TemplateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/team")
public class TeamController {


    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/index")
    public String showTeamList(@PageableDefault(size = 50) Pageable pageable, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        Page<Team> page = teamRepository.findAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("count", teamRepository.count());
        //model.addAttribute("teams", teamRepository.findAll());
        return "business/team/index";
    }

    // add user
    @GetMapping("/add")
    public String showAddForm(Team team, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        return "team/add-team";
    }

    @PostMapping("/addteam")
    public String addTeam(@Valid Team team, BindingResult result, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        if (result.hasErrors()) {
            return "team/add-team";
        }
        teamRepository.save(team);
        return "redirect:team/index";
    }


    // edit user
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        Team team = teamRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid team Id:" + id));
        model.addAttribute("team", team);
        return "team/update-team";
    }


    @PostMapping("/update/{id}")
    public String updateTeam(@PathVariable("id") Long id, @Valid Team team, BindingResult result, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        if (result.hasErrors()) {
            team.setId(id);

            return "team/update-team";
        }

        teamRepository.save(team);
        return "redirect:/team/index";
    }


    /// delete
    @GetMapping("/delete/{id}")
    public String deleteTeam(@PathVariable("id") Long id, Model model) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        teamRepository.delete(team);
        return "redirect:team/index";
    }


}





