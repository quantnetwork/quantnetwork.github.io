trigger="on_demand";

def reserveId = ${reserveId:string};
def name = ${name:string?};
def priority = ${priority:int?};   
def savingGoal = ${savingGoal:decimal?};
def description = ${description:string?};

def updateReserveInfo = new UpdateReserveInfo(reserveId, name, priority, savingGoal, description);
editReserve(updateReserveInfo);