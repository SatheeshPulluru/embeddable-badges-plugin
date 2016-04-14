/*
* The MIT License
*
* Copyright 2013 Dominik Bartholdi.
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
*/
package org.jenkinsci.plugins.badge;

import hudson.Plugin;

/**
 * This plugin implementation only exists to force the loading of the permission
 * in an early enough stage (see also JENKINS-4172).
 * If the permission is not loaded early enough, Jenkins fails to load
 * permissions from config.
 *
 * @author Dominik Bartholdi (imod)
 */
public class PluginImpl extends Plugin {

    /**
     * TO DO
     * @throws Exception
     */
    @Override
    public void start() throws Exception {
        //
        // As a work around, force loading of this permission so that by
        // the time we start loading ACLs,
        // we have this instance already registered, thereby avoiding a lookup.
        PublicBadgeAction.VIEW_STATUS.toString();
    }

}
