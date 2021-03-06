/*
 * LangSchema-Java - Programming Language Modeling Classes for Java (TM)
 * Copyright (C) 2005 Newisys, Inc. or its licensors, as applicable.
 * Java is a registered trademark of Sun Microsystems, Inc. in the U.S. or
 * other countries.
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

package com.newisys.langschema.java;

import com.newisys.langschema.IfStatement;

/**
 * Represents a Java 'if' statement.
 * 
 * @author Trevor Robinson
 */
public final class JavaIfStatement
    extends JavaStatement
    implements IfStatement
{
    private final JavaExpression condition;
    private final JavaStatement thenStatement;
    private JavaStatement elseStatement;

    public JavaIfStatement(
        JavaExpression condition,
        JavaStatement thenStatement,
        JavaStatement elseStatement)
    {
        super(condition.schema);
        assert (condition.getResultType() instanceof JavaBooleanType);
        this.condition = condition;
        thenStatement.setContainingStatement(this);
        this.thenStatement = thenStatement;
        if (elseStatement != null)
        {
            elseStatement.setContainingStatement(this);
        }
        this.elseStatement = elseStatement;
    }

    public JavaIfStatement(JavaExpression condition, JavaStatement thenStatement)
    {
        this(condition, thenStatement, null);
    }

    public JavaExpression getCondition()
    {
        return condition;
    }

    public JavaStatement getThenStatement()
    {
        return thenStatement;
    }

    public JavaStatement getElseStatement()
    {
        return elseStatement;
    }

    public void setElseStatement(JavaStatement elseStatement)
    {
        if (elseStatement != null)
        {
            elseStatement.setContainingStatement(this);
        }
        this.elseStatement = elseStatement;
    }

    public void accept(JavaStatementVisitor visitor)
    {
        visitor.visit(this);
    }

    public String toDebugString()
    {
        return "if statement";
    }
}
