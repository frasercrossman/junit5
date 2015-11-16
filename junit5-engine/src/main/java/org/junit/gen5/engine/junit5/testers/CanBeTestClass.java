/*
 * Copyright 2015 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.junit.gen5.engine.junit5.testers;

import static org.junit.gen5.commons.util.ReflectionUtils.isAbstract;
import static org.junit.gen5.commons.util.ReflectionUtils.isStatic;

import java.util.function.Predicate;

/**
 * @since 5.0
 */
public class CanBeTestClass implements Predicate<Class<?>> {

	@Override
	public boolean test(Class<?> candidate) {
		return (!isAbstract(candidate) && !candidate.isLocalClass()
				&& (isStatic(candidate) || !candidate.isMemberClass()));
	}

}
