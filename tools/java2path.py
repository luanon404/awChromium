import os
import json
from utils import Utils
from pathlib import Path


def update_structure(target, source):
    for key, value in source.items():
        if key in target:
            if isinstance(target[key], dict) and isinstance(value, dict):
                update_structure(target[key], value)
            else:
                target[key] = [target[key], value]
        else:
            target[key] = value
    return target

if __name__ == "__main__":
    prefix = "/"
    utils = Utils(prefix)
    target_path = "/home/luanon404/Downloads/Moe-Moe-main/aw_chromium/src/main/java"
    allow_export = [
        "J",
        "org"
    ]
    result = {}

    for file in Path(target_path).glob("**/*.java"):
        print("Updating...", end="\r")
        package_name = os.path.dirname(str(file).replace(target_path, "")).strip(prefix)
        if any(package_name.startswith(allow) for allow in allow_export):
            current = {
                "target": [],
                "dest": package_name,
                "times": 0
            }
            for part in reversed(utils.join(package_name, file.name).split(prefix)):
                current = {part: current}
            result = update_structure(result, current)

    json.dump(result, open(utils.join(os.path.dirname(__file__), "structure.json"), "w"), indent=4, sort_keys=True)
