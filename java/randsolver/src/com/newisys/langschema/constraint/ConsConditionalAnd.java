/*
 * Jove Constraint-based Random Solver
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

package com.newisys.langschema.constraint;

import com.newisys.langschema.java.JavaType;

public final class ConsConditionalAnd
    extends ConsBinaryOperation
{
    public ConsConditionalAnd(ConsExpression op1, ConsExpression op2)
    {
        super(op1, op2);
        assert (schema.isDVIntegral(op1.getResultType()) && schema
            .isDVIntegral(op2.getResultType()));
    }

    public JavaType getResultType()
    {
        return schema.booleanType;
    }

    public String toSourceString()
    {
        return "(" + operands[0] + " && " + operands[1] + ")";
    }

    public void accept(ConsConstraintExpressionVisitor visitor)
    {
        visitor.visit(this);
    }
}
