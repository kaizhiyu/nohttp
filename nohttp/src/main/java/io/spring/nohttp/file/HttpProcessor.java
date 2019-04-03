/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.spring.nohttp.file;

import io.spring.nohttp.HttpMatchResult;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Rob Winch
 */
public abstract class HttpProcessor {

	private Set<String> httpMatches = new TreeSet<String>();

	public List<HttpMatchResult> processFile(File file) {
		List<HttpMatchResult> matches = processHttpInFile(file);

		matches.forEach(match -> {
			this.httpMatches.add(match.getHttp());
		});

		return matches;
	}

	protected abstract List<HttpMatchResult> processHttpInFile(File file);

	public Set<String> getHttpMatches() {
		return Collections.unmodifiableSet(this.httpMatches);
	}
}
