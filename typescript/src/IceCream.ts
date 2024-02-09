export enum IceCream {
    Strawberry ,
    Chocolate ,
    Vanilla ,
}

export const IceCreamName = (iceCream: IceCream): string => {
    switch (iceCream) {
        case IceCream.Strawberry:
            return "Strawberry";
        case IceCream.Chocolate:
            return "Chocolate";
        case IceCream.Vanilla:
            return "Vanilla";
    }
}

export const IceCreamValues = [IceCream.Strawberry, IceCream.Chocolate, IceCream.Vanilla];
