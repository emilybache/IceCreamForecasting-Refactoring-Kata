import fs from "fs";

export const readApprovalLinesOf = (filepath: string) => fs.readFileSync(filepath).toString().split('\n').map(line => line.trim()).filter(line => line.length > 0);
export const readApprovalFirstLineOf = (filepath: string) => readApprovalLinesOf(filepath)[0];