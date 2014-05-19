/*
 * LangSchema - Generic Programming Language Modeling Interfaces
 * Copyright (C) 2005 Newisys, Inc. or its licensors, as applicable.
 *
 * Licensed under the Open Software License version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You should
 * have received a copy of the License along with this software; if not, you
 * may obtain a copy of the License at
 *
 * http://opensource.org/licenses/osl-2.0.php
 *
 * This software is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.newisys.langschema;

import java.util.Set;

/**
 * Represents a function.
 * 
 * @author Trevor Robinson
 */
public interface Function
    extends Functor, NamedObject
{
    /**
     * Returns a collection of any language-specific modifiers for this
     * function.
     *
     * @return Set of FunctionModifier
     */
    Set< ? extends FunctionModifier> getModifiers();
}