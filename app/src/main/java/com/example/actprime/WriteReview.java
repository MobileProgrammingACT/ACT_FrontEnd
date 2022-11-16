package com.example.actprime;

/*저장하는 메소드 - 분명.. 한 클래스 내에서 할 수 있었겠지만.. 제 실력부족으로 따로 빼야했습니다...*/
public class WriteReview {
    String content;
    public WriteReview(){}

    public String getcontent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public WriteReview(String content){
            this.content = content;
        }
    }
