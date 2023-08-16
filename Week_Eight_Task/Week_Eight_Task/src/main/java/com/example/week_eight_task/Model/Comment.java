package com.example.week_eight_task.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (nullable = false)
    private String content;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = true)
    private User user;
    @ManyToOne
    @JoinColumn(name = "postId", nullable = false)
    private Post post;

}
