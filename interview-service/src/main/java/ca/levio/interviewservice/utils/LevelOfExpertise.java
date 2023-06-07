package ca.levio.interviewservice.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LevelOfExpertise {
  JUNIOR('A', "Junior"),
  INTERMEDIATE('B', "Intermediate"),
  SENIOR('C', "Senior"),
  SENIOR_PLUS('D', "Senior plus"),
  SKILLED('E', "Skilled");

  private final char code;
  private final String level;

  public static String valueOfLevel(char code) {
    for (LevelOfExpertise e : values()) {
      if (e.code == code) {
        return e.level;
      }
    }
    return null;
  }

  public static Character valueOfCode(String label) {
    for (LevelOfExpertise e : values()) {
      if (e.level.equals(label)) {
        return e.code;
      }
    }
    return null;
  }

  /*
      This method verified the level of expertise between the Technical Advisor and the Applcant,
      the eligible Technical Advisor must be at least at the same level or higher than the Applcant.
      @True : same or higher
      @False : lower
  */
  public static boolean compareOfExpertise(char codeApplicant, char codeTechnicalAdvisor) {
    return codeApplicant <= codeTechnicalAdvisor;
  }

}