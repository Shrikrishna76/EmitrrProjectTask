package com.example.demo.model;

import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name="questions_table")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ElementCollection
    @CollectionTable(name = "question_options", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "answer")
    private List<String> options;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(name = "correct_option")
    private String correctOption;

    private int difficulty;

    private int marks;

	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Questions(Long id, String text, List<String> options, String correctOption, int difficulty, int marks) {
		super();
		this.id = id;
		this.text = text;
		this.options = options;
		this.correctOption = correctOption;
		this.difficulty = difficulty;
		this.marks = marks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Questions [id=" + id + ", text=" + text + ", options=" + options + ", correctOption=" + correctOption
				+ ", difficulty=" + difficulty + ", marks=" + marks + "]";
	}
    
	public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
    
    
}
