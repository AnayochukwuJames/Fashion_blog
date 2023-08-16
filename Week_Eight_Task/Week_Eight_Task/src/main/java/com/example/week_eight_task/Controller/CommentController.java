package com.example.week_eight_task.Controller;
import com.example.week_eight_task.Model.Comment;
import com.example.week_eight_task.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private CommentService commentService;
@Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping("/post/{postId}")
    public ResponseEntity<Comment> createComment(@PathVariable Long postId, @RequestBody Comment comment){
        Comment createdComment = commentService.createComment(postId, comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }
@GetMapping("/{commentId}")
    public ResponseEntity<Comment> getComment(@PathVariable Long commentId){
        Comment commentDto = commentService.findCommentById(commentId);
        if (commentDto != null){
            return ResponseEntity.ok(commentDto);
        }else {
            return ResponseEntity.notFound().build();
        }

}
    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok("Comment deleted successfully");
    }
}
