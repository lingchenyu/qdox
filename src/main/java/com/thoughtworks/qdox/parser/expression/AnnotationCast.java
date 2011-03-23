package com.thoughtworks.qdox.parser.expression;

import com.thoughtworks.qdox.builder.AnnotationTransformer;
import com.thoughtworks.qdox.model.Type;
import com.thoughtworks.qdox.parser.structs.TypeDef;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

public class AnnotationCast implements AnnotationValue, ElemValueDef {

    private final Type type;
    private final AnnotationValue value;
    
    public TypeDef typeDef;
    public ElemValueDef elemDef;

    public AnnotationCast( Type type, AnnotationValue value ) {
        this.type = type;
        this.value = value;
    }

    public AnnotationCast(TypeDef type, ElemValueDef value) {
    	this.type = null; 
    	this.value = null;
    	this.typeDef = type;
    	this.elemDef = value;
	}
	
	public Type getType() {
        return this.type;
    }

    public AnnotationValue getValue() {
        return this.value;
    }

    public Object accept( AnnotationVisitor visitor ) {
        return visitor.visitAnnotationCast( this );
    }

    public Object getParameterValue() {
        return "(" + type.getValue() + ") " + value.getParameterValue();
    }

    public String toString() {
        return "(" + type.getValue() + ") " + value.toString();
    }
    
    public <U> U transform(AnnotationTransformer<U> transformer) {
    	return transformer.transform(this);
    }

}