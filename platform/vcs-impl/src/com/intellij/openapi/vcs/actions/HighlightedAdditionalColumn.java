/*
 * Copyright 2000-2010 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.openapi.vcs.actions;

import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.vcs.annotate.FileAnnotation;
import com.intellij.openapi.vcs.annotate.HighlightAnnotationsActions;
import com.intellij.openapi.vcs.annotate.LineAnnotationAspect;
import com.intellij.openapi.vcs.annotate.TextAnnotationPresentation;

import java.awt.*;
import java.util.Map;

/**
 * @author Konstantin Bulenkov
 */
class HighlightedAdditionalColumn extends AnnotationFieldGutter {
  private final HighlightAnnotationsActions myHighlighting;

  HighlightedAdditionalColumn(FileAnnotation annotation,
                              Editor editor,
                              LineAnnotationAspect aspect,
                              TextAnnotationPresentation presentation,
                              final HighlightAnnotationsActions highlighting,
                              Map<String, Color> colorScheme) {
    super(annotation, editor, aspect, presentation, colorScheme);
    myHighlighting = highlighting;
  }

  @Override
  public String getLineText(int line, Editor editor) {
    return myHighlighting.isLineBold(line) ? "*" : "";
  }
}