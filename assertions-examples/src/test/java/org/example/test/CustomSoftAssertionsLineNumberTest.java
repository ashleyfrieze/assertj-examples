/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2016 the original author or authors.
 */
package org.example.test;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * The assertions classes have to be in a package other than org.assertj because it tests explicitely the behaviour of line numbers for assertions defined outsode assertj package
 */
public class CustomSoftAssertionsLineNumberTest {

  @Test
  // @Disabled
  public void should_print_line_numbers_of_failed_assertions_even_if_custom_assertion_in_non_assertj_package() {
    MyProjectSoftAssertions softly = new MyProjectSoftAssertions();
    softly.assertThat(new MyProjectClass("v1")).hasValue("v2");
    softly.assertAll();
    try {
      fail("Should not reach here");
    } catch (AssertionError e) {
      assertThat(e.getMessage()).contains(format("at CustomSoftAssertionsLineNumberTest.should_print_line_numbers_of_failed_assertions_even_if_custom_assertion_in_non_assertj_package(CustomSoftAssertionsLineNumberTest.java:31)"));
    }
  }

}
