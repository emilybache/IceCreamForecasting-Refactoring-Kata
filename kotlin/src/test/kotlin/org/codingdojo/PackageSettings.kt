package org.codingdojo

import org.approvaltests.core.ApprovalFailureReporter
import org.approvaltests.reporters.JunitReporter

class PackageSettings {
    var UseReporter: ApprovalFailureReporter = JunitReporter.INSTANCE
}