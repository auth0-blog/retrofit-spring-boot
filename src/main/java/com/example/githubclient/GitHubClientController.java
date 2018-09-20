package com.example.githubclient;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.event.DeletePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class GitHubClientController {
    @Autowired
    private GitHubService githubService;

    @GetMapping("/repos")
    public List<Repository> getRepos() throws IOException {
        return githubService.getRepositories();
    }

    @PostMapping("/repos")
    public Repository createRepo(@RequestBody Repository newRepo) throws IOException {
        return githubService.createRepository(newRepo);
    }

    @DeleteMapping("/repos/{owner}/{repo}")
    public DeletePayload deleteRepo(
            @PathVariable("owner") String owner,
            @PathVariable("repo") String repoName) throws IOException {
        return githubService.deleteRepository(owner, repoName);
    }
}
